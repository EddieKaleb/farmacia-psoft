package br.edu.ufcg.pharma.api.seguranca;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.ufcg.pharma.api.model.Usuario;
import br.edu.ufcg.pharma.api.repositorio.UsuarioRepositorio;

@Service
public class UsuarioDetalhesServico implements UserDetailsService {

	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepositorio.findByEmail(email);
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuário e/ou senha incorretos");
		}
		return new User(email, usuario.getSenha(), getPermissoes(usuario));
	}

	private Collection<? extends GrantedAuthority> getPermissoes(Usuario usuario) {
		Set<SimpleGrantedAuthority> permissoes = new HashSet<>();
		permissoes.add(new SimpleGrantedAuthority(usuario.getTipo().getPapel().toUpperCase()));
		return permissoes;
	}

	
}
