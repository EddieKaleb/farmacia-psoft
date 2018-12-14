package br.edu.ufcg.pharma.api.servico;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ufcg.pharma.api.model.Produto;
import br.edu.ufcg.pharma.api.repositorio.ProdutoRepositorio;

@Service
public class ProdutoServico {
	
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	public Produto atualizar(Integer id, Produto produto) {
		Produto produtoSalvo = buscarCategoriaPorId(id);

		BeanUtils.copyProperties(produto, produtoSalvo, "id");
		return produtoRepositorio.save(produtoSalvo);
	}

	private Produto buscarCategoriaPorId(Integer id) {
		Produto produtoSalvo = produtoRepositorio.findOne(id);

		if (produtoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return produtoSalvo;
	}
	
}
