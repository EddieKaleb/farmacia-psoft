package br.edu.ufcg.pharma.api.servico;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ufcg.pharma.api.model.Estoque;
import br.edu.ufcg.pharma.api.model.Produto;
import br.edu.ufcg.pharma.api.model.ProdutoSituacao;
import br.edu.ufcg.pharma.api.repositorio.EstoqueRepositorio;
import br.edu.ufcg.pharma.api.repositorio.ProdutoRepositorio;
import br.edu.ufcg.pharma.api.repositorio.ProdutoSituacaoRepositorio;

@Service
public class ProdutoServico {
	
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	@Autowired
	private EstoqueServico estoqueServico;
	
	@Autowired
	private LoteServico loteServico;

	@Autowired
	private ProdutoSituacaoRepositorio produtoSituacaoRepositorio;
	
	@Autowired
	private EstoqueRepositorio estoqueRepositorio;
	
	public Produto atualizar(Integer id, Produto produto) {
		Produto produtoSalvo = buscarProdutoPorId(id);

		BeanUtils.copyProperties(produto, produtoSalvo, "id");
		return produtoRepositorio.save(produtoSalvo);
	}
	
	public Produto atualizarSituacao(Produto produto, Integer situacao) {
		Produto produtoSalvo = buscarProdutoPorId(produto.getId());
		ProdutoSituacao situacaoSalva = produtoSituacaoRepositorio.findOne(situacao);
		produtoSalvo.setSituacao(situacaoSalva);
		return produtoRepositorio.save(produtoSalvo);
	}

	private Produto buscarProdutoPorId(Integer id) {
		Produto produtoSalvo = produtoRepositorio.findOne(id);

		if (produtoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return produtoSalvo;
	}

	public void remover(Integer id) {
		Produto produtoSalvo = buscarProdutoPorId(id);
		this.loteServico.removerTodosPorProdutoId(produtoSalvo.getId());
		Estoque estoque = estoqueRepositorio.findByProdutoId(produtoSalvo.getId());
		if (estoque != null) this.estoqueRepositorio.delete(estoque.getId());
	}
	
}
