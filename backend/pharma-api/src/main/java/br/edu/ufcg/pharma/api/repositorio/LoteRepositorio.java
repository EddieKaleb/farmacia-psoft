package br.edu.ufcg.pharma.api.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufcg.pharma.api.model.Lote;

public interface LoteRepositorio extends JpaRepository<Lote, Integer> {

	public List<Lote> findAllByProdutoId(Integer id);
}
