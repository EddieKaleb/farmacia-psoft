package br.edu.ufcg.pharma.api.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufcg.pharma.api.model.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{

	public Optional<Usuario> findByEmail(String email);
}
