package br.edu.ufcg.pharma.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufcg.pharma.api.model.Estoque;

public interface EstoqueRepositorio extends JpaRepository<Estoque, Integer> {

	public Estoque findByProdutoId(Integer id);
	
}
