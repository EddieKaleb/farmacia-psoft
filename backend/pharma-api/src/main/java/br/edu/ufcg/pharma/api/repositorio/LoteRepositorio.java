package br.edu.ufcg.pharma.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufcg.pharma.api.model.Lote;

public interface LoteRepositorio extends JpaRepository<Lote, Integer> {

}
