package br.edu.ufcg.pharma.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufcg.pharma.api.model.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{

	public Usuario findByEmail(String email);
	
	public Usuario findByCpf(String cpf);
	
	public Usuario findByRg(String email);
}
