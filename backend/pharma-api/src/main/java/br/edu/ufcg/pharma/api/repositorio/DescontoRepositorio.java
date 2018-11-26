package br.edu.ufcg.pharma.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufcg.pharma.api.model.Desconto;

public interface DescontoRepositorio extends JpaRepository<Desconto, Integer> {

}
