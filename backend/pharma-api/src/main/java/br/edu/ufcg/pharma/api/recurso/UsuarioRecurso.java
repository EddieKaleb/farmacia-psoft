package br.edu.ufcg.pharma.api.recurso;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import br.edu.ufcg.pharma.api.evento.RecursoCriadoEvento;
import br.edu.ufcg.pharma.api.exceptionhandler.PharmaExceptionHandler.Erro;
import br.edu.ufcg.pharma.api.model.Usuario;
import br.edu.ufcg.pharma.api.repositorio.UsuarioRepositorio;
import br.edu.ufcg.pharma.api.servico.UsuarioServico;
import br.edu.ufcg.pharma.api.servico.exception.UsuarioCpfJaCadastradoException;
import br.edu.ufcg.pharma.api.servico.exception.UsuarioEmailJaCadastradoException;
import br.edu.ufcg.pharma.api.servico.exception.UsuarioRgJaCadastradoException;

@RestController
@RequestMapping("/usuarios")
public class UsuarioRecurso {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private UsuarioServico usuarioServico;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Usuario> listar() {
		return usuarioRepositorio.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Usuario> criar(@RequestBody @Valid Usuario usuario, HttpServletResponse resposta) {
		Usuario usuarioSalvo =  this.usuarioServico.salvar(usuario);
		publisher.publishEvent(new RecursoCriadoEvento(this, resposta, usuarioSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable Integer id) {
		Usuario usuario = this.usuarioRepositorio.findOne(id);
		return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler({ UsuarioEmailJaCadastradoException.class })
	public ResponseEntity<Object> handleUsuarioEmailJaCadastradoException(UsuarioEmailJaCadastradoException ex, WebRequest request) {
		String mensagemUsr = messageSource.getMessage("recurso.email-nao-permitido", null, LocaleContextHolder.getLocale());
		String mensagemDev =  ExceptionUtils.getRootCauseMessage(ex);
		List<Erro> erros = Arrays.asList(new Erro(mensagemUsr,mensagemDev));
		return ResponseEntity.badRequest().body(erros);
	}
	
	@ExceptionHandler({ UsuarioCpfJaCadastradoException.class })
	public ResponseEntity<Object> handleUsuarioCpfJaCadastradoException(UsuarioCpfJaCadastradoException ex, WebRequest request) {
		String mensagemUsr = messageSource.getMessage("recurso.cpf-nao-permitido", null, LocaleContextHolder.getLocale());
		String mensagemDev =  ExceptionUtils.getRootCauseMessage(ex);
		List<Erro> erros = Arrays.asList(new Erro(mensagemUsr,mensagemDev));
		return ResponseEntity.badRequest().body(erros);
	}
	
	@ExceptionHandler({ UsuarioRgJaCadastradoException.class })
	public ResponseEntity<Object> handleUsuarioRgJaCadastradoException(UsuarioRgJaCadastradoException ex, WebRequest request) {
		String mensagemUsr = messageSource.getMessage("recurso.rg-nao-permitido", null, LocaleContextHolder.getLocale());
		String mensagemDev =  ExceptionUtils.getRootCauseMessage(ex);
		List<Erro> erros = Arrays.asList(new Erro(mensagemUsr,mensagemDev));
		return ResponseEntity.badRequest().body(erros);
	}

}
