package br.edu.ufcg.pharma.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufcg.pharma.api.model.VendaStatus;

public interface VendaStatusRepositorio extends JpaRepository<VendaStatus, Integer>{

}
