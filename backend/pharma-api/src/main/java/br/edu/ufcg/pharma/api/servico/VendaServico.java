package br.edu.ufcg.pharma.api.servico;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ufcg.pharma.api.model.Categoria;
import br.edu.ufcg.pharma.api.model.Estoque;
import br.edu.ufcg.pharma.api.model.Lote;
import br.edu.ufcg.pharma.api.model.Venda;
import br.edu.ufcg.pharma.api.model.VendaProduto;
import br.edu.ufcg.pharma.api.model.VendaStatus;
import br.edu.ufcg.pharma.api.repositorio.LoteHistoricoRepositorio;
import br.edu.ufcg.pharma.api.repositorio.LoteRepositorio;
import br.edu.ufcg.pharma.api.repositorio.ProdutoRepositorio;
import br.edu.ufcg.pharma.api.repositorio.VendaProdutoRepositorio;
import br.edu.ufcg.pharma.api.repositorio.VendaRepositorio;
import br.edu.ufcg.pharma.api.repositorio.VendaStatusRepositorio;
import br.edu.ufcg.pharma.api.servico.exception.EstoqueInsuficienteException;

@Service
public class VendaServico {

	@Autowired
	private VendaRepositorio vendaRepositorio;
	
	@Autowired
	private VendaProdutoRepositorio vendaProdutoRepositorio;
	
	@Autowired
	private EstoqueServico estoqueServico;
	
	@Autowired
	private LoteHistoricoRepositorio loteHistoricoRepositorio;
	
	@Autowired
	private LoteRepositorio loteRepositorio;
	
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	@Autowired
	private VendaStatusRepositorio vendaStatusRepositorio;
	
	public Venda iniciar(Venda venda) {
		VendaStatus status = this.vendaStatusRepositorio.findOne(4);
		venda.setStatus(status);
		venda.setData(new Date());
		venda.setValorSubtotal(0.0);
		venda.setValorTotal(0.0);
		return this.vendaRepositorio.save(venda);
	}
	
	public Venda finalizar(Integer id) {
		Venda vendaSalva = buscarVendaPorId(id);
		VendaStatus status = this.vendaStatusRepositorio.findOne(1);
		vendaSalva.setStatus(status);
		
		List<VendaProduto> produtos = this.vendaProdutoRepositorio.findAllByVendaId(id);
				
		int i = 0;
		int j = produtos.size();
		
		Double valorTotal = 0.0;
		Double valorSubtotal = 0.0;
		
		while (i < j) {
			List<Lote> lotes = this.loteRepositorio.findAllByProdutoId(produtos.get(i).getProduto().getId());
			int qntProd = produtos.get(i).getQuantidade();
			valorTotal += produtos.get(i).getValorTotal();
			valorSubtotal += produtos.get(i).getValorSubtotal();
			int x = 0;
			int y = lotes.size();
			
			while (x < y) {
				if (lotes.get(x).getQuantidade() >= produtos.get(i).getQuantidade()) {
					lotes.get(x).setQuantidade(lotes.get(x).getQuantidade() - produtos.get(i).getQuantidade());
					break;
				} else {
					lotes.get(x).setQuantidade(0);
					produtos.get(i).setQuantidade(produtos.get(i).getQuantidade() - lotes.get(x).getQuantidade());
				}
				x++;
			}
			this.estoqueServico.atualizar(lotes.get(x));
			i++;
		}
		
		vendaSalva.setValorTotal(valorTotal);
		vendaSalva.setValorSubtotal(valorSubtotal);
		
		return this.vendaRepositorio.save(vendaSalva);
	}
	
	/*
	public Venda cancelar(Integer id) {
		Venda vendaSalva = buscarVendaPorId(id);
		VendaStatus status = this.vendaStatusRepositorio.findOne(1);
		vendaSalva.setStatus(status);
		
		List<VendaProduto> produtos = this.vendaProdutoRepositorio.findAllByVendaId(id);
				
		int i = 0;
		int j = produtos.size();
		
		while (i < j) {
			List<Lote> lotes = this.loteRepositorio.findAllByProdutoId(produtos.get(i).getProduto().getId());
			
			List<LoteHistorico> historico = loteHistoricoRepositorio
					.findAllByVendaIdAndLoteId(vendaSalva.getId(), produtos.get(i).getProduto().getId());
			
			int x = 0;
			int y = historico.size();
			
			while (x < y) {
				if (lotes.get(x).getQuantidade() != historico.getQuantidadeAnterior()) {
					lotes.get(x).setQuantidade(lotes.get(x).getQuantidade() - produtos.get(i).getQuantidade());
					break;
				} else {
					lotes.get(x).setQuantidade(0);
					produtos.get(i).setQuantidade(produtos.get(i).getQuantidade() - lotes.get(x).getQuantidade());
				}
				x++;
			}
			this.estoqueServico.atualizar(lotes.get(x));
			i++;
		}
		
		return this.vendaRepositorio.save(vendaSalva);
	}*/
	
	public void deletar(Integer id) {
		Venda venda = this.vendaRepositorio.findOne(id);
		VendaStatus status = this.vendaStatusRepositorio.findOne(2);
		venda.setStatus(status);
	}

	public VendaProduto adicionarProdutoVenda(VendaProduto produtoVenda) {
		int quant = produtoVenda.getQuantidade();
		Estoque estoque = estoqueServico.buscarEstoquePorProdutoId(produtoVenda.getProduto().getId());
		
		if (quant > getTotalProdutosValidos(produtoVenda.getProduto().getId())) {
			throw new EstoqueInsuficienteException();
		}
		
		double valorProd = 100;
		Categoria categoria = estoque.getProduto().getCategoria();
		double desconto = categoria.getDesconto().getPorcentagem();
		produtoVenda.setValorUnitario(valorProd);
		produtoVenda.setValorSubtotal(valorProd * quant);
		produtoVenda.setValorTotal((valorProd * quant) * desconto);
		return this.vendaProdutoRepositorio.save(produtoVenda);
	}
	
	private int getTotalProdutosValidos(Integer id) {
		int total = 0;
		
		List<Lote> lotes = loteRepositorio.findAllByProdutoId(id);
		
		for (int i = 0; i < lotes.size(); i++) {
			if (lotes.get(i).getSituacao().getSituacao().equals("Válido")) {
				total += lotes.get(i).getQuantidade();
			}
		}
		return total;
	}
	
	private Venda buscarVendaPorId(Integer id) {
		Venda vendaSalva = vendaRepositorio.findOne(id);

		if (vendaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return vendaSalva;
	}
	
}
