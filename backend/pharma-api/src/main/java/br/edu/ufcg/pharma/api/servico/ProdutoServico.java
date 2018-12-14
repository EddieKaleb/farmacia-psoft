package br.edu.ufcg.pharma.api.servico;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ufcg.pharma.api.model.Produto;
import br.edu.ufcg.pharma.api.model.ProdutoSituacao;
import br.edu.ufcg.pharma.api.repositorio.ProdutoRepositorio;
import br.edu.ufcg.pharma.api.repositorio.ProdutoSituacaoRepositorio;

@Service
public class ProdutoServico {
	
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	@Autowired
	private ProdutoSituacaoRepositorio produtoSituacaoRepositorio;
	
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
	
}
