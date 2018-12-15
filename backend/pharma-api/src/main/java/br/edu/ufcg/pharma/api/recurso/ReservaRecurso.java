package br.edu.ufcg.pharma.api.recurso;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufcg.pharma.api.evento.RecursoCriadoEvento;
import br.edu.ufcg.pharma.api.model.Reserva;
import br.edu.ufcg.pharma.api.repositorio.ReservaRepositorio;
import br.edu.ufcg.pharma.api.servico.ReservaServico;

@RestController
@RequestMapping("/reservas")
public class ReservaRecurso {
	@Autowired
	private ReservaRepositorio reservaRepositorio;
	
	@Autowired
	private ReservaServico reservaServico;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Reserva> listar() {
		return this.reservaRepositorio.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Reserva> criar(@RequestBody @Valid Reserva reserva, HttpServletResponse resposta) {
		Reserva reservaSalva = this.reservaServico.salvar(reserva);
		publisher.publishEvent(new RecursoCriadoEvento(this, resposta, reservaSalva.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(reservaSalva);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Reserva> buscarPorId(@PathVariable Integer id) {
		Reserva reserva = this.reservaRepositorio.findOne(id);
		return reserva != null ? ResponseEntity.ok(reserva) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Integer id) {
		this.reservaRepositorio.delete(id);
	}
}
