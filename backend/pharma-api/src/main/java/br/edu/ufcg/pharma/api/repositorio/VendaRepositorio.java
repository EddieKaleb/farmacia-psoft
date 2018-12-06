package br.edu.ufcg.pharma.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufcg.pharma.api.model.Venda;

public interface VendaRepositorio extends JpaRepository<Venda, Integer>{

}
