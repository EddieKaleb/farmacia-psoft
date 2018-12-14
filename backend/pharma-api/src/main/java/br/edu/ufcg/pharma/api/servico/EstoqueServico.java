package br.edu.ufcg.pharma.api.servico;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ufcg.pharma.api.model.Estoque;
import br.edu.ufcg.pharma.api.model.Lote;
import br.edu.ufcg.pharma.api.repositorio.EstoqueRepositorio;
import br.edu.ufcg.pharma.api.repositorio.LoteRepositorio;
import br.edu.ufcg.pharma.api.repositorio.ProdutoSituacaoRepositorio;

@Service
public class EstoqueServico {

	@Autowired
	private EstoqueRepositorio estoqueRepositorio;
	
	@Autowired
	private LoteRepositorio loteRepositorio;
	
	@Autowired
	private ProdutoSituacaoRepositorio produtoSituacaoRepositorio;
	
	@Autowired
	private ProdutoServico produtoServico;
	
	@Autowired
	private LoteServico loteServico;
	
	public void salvar(Lote lote) {
		Estoque estoqueSalvo = estoqueRepositorio.findByProdutoId(lote.getProduto().getId());
		
		if (estoqueSalvo == null) {
			Estoque estoque = new Estoque();
			estoque.setProduto(lote.getProduto());
			estoque.setQuantidade(lote.getQuantidade());
			estoque.setReceita(0.0);
			estoque.setSituacao("Disponível");
		} else {
			estoqueSalvo.setQuantidade(estoqueSalvo.getQuantidade() + lote.getQuantidade());
		}
	}
	
	public void atualizar(Lote lote) {
		List<Lote> lotes = loteRepositorio.findAllByProdutoId(lote.getProduto().getId());
		Estoque estoqueSalvo = buscarEstoquePorProdutoId(lote.getProduto().getId());
		
		int total = 0;
		
		for (int i = 0; i < lotes.size(); i++) {
			total += lotes.get(i).getQuantidade();
		}
		
		if (total == 0) {
			estoqueSalvo.setSituacao("Indisponível");
		} else {
			estoqueSalvo.setSituacao("Disponível");
		}
		
		estoqueSalvo.setQuantidade(total);
		this.estoqueRepositorio.save(estoqueSalvo);
	}
	
	public Estoque atualizarValidadePorProdutoId(Integer id) {
		Estoque estoqueSalvo = estoqueRepositorio.findByProdutoId(id);
		List<Lote> lotes = loteRepositorio.findAllByProdutoId(id);
		
		int totalLotes = lotes.size();
		int lotesVencidos = 0;
		Date dataHoje = new Date();
		
		for(int i = 0; i < lotes.size(); i++) {
			if (dataHoje.after(lotes.get(i).getValidade())) {
				this.loteServico.atualizarSituacao(lotes.get(0), 2);
				lotesVencidos += 1;
			} else {
				this.loteServico.atualizarSituacao(lotes.get(0), 1);
			}
		}
		
		if (lotesVencidos == totalLotes) {
			estoqueSalvo.setSituacao("Vencido");
			this.produtoServico.atualizarSituacao(estoqueSalvo.getProduto(), 2);
		} else {
			estoqueSalvo.setSituacao("Disponível");
			this.produtoServico.atualizarSituacao(estoqueSalvo.getProduto(), 1);
		}
		
		return this.estoqueRepositorio.save(estoqueSalvo);
	}
	
	private Estoque buscarEstoquePorProdutoId(Integer id) {
		Estoque estoqueSalvo = estoqueRepositorio.findByProdutoId(id);

		if (estoqueSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return estoqueSalvo;
	}
	
}
