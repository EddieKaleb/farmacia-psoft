package br.edu.ufcg.pharma.api.servico;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import br.edu.ufcg.pharma.api.model.Usuario;
import br.edu.ufcg.pharma.api.repositorio.UsuarioRepositorio;
import br.edu.ufcg.pharma.api.servico.exception.UsuarioCpfJaCadastradoException;
import br.edu.ufcg.pharma.api.servico.exception.UsuarioEmailJaCadastradoException;
import br.edu.ufcg.pharma.api.servico.exception.UsuarioRgJaCadastradoException;

@Service
public class UsuarioServico {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	public Usuario buscar(Usuario usuario) {
		Usuario usuarioSalvo = usuarioRepositorio.findByEmail(usuario.getEmail());
		
		if (usuarioSalvo != null) {
			throw new UsuarioEmailJaCadastradoException();
		}
		
		usuarioSalvo = usuarioRepositorio.findByCpf(usuario.getCpf());
		
		if (usuarioSalvo != null) {
			throw new UsuarioCpfJaCadastradoException();
		}
		
		usuarioSalvo = usuarioRepositorio.findByRg(usuario.getRg());
		
		if (usuarioSalvo != null) {
			throw new UsuarioRgJaCadastradoException();
		}
		
	    return this.usuarioRepositorio.save(usuario);
	}

	public Usuario login(Usuario usuario) {
		Usuario usuarioSalvo = usuarioRepositorio.findByEmail(usuario.getEmail());
		
		if (usuarioSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		boolean compare = BCrypt.checkpw(usuario.getSenha(), usuarioSalvo.getSenha());
		return compare == true ? usuarioSalvo : null;
	}
	

}
