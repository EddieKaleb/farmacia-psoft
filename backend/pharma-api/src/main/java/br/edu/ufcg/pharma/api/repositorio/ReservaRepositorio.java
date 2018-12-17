package br.edu.ufcg.pharma.api.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufcg.pharma.api.model.Reserva;

public interface ReservaRepositorio extends JpaRepository<Reserva, Integer>{

	public List<Reserva> findAllByUsuarioId(Integer id);

}
