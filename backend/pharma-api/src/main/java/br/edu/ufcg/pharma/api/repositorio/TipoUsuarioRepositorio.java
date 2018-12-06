package br.edu.ufcg.pharma.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufcg.pharma.api.model.TipoUsuario;

public interface TipoUsuarioRepositorio extends JpaRepository<TipoUsuario, Integer>{

}
