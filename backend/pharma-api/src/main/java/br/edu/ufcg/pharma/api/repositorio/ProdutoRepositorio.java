package br.edu.ufcg.pharma.api.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufcg.pharma.api.model.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Integer>{

	public List<Produto> findAllByCategoriaId(Integer id);

}
