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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufcg.pharma.api.evento.RecursoCriadoEvento;
import br.edu.ufcg.pharma.api.model.Lote;
import br.edu.ufcg.pharma.api.repositorio.LoteRepositorio;
import br.edu.ufcg.pharma.api.servico.LoteServico;

@RestController
@RequestMapping("/lotes")
public class LoteRecurso {

	@Autowired
	private LoteRepositorio loteRepositorio;
	
	@Autowired
	private LoteServico loteServico;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<Lote> listar() {
		return this.loteRepositorio.findAll();
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Lote> criar(@RequestBody @Valid Lote lote, HttpServletResponse resposta) {
		Lote loteSalvo = this.loteRepositorio.save(lote);
		publisher.publishEvent(new RecursoCriadoEvento(this, resposta, loteSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(loteSalvo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Lote> buscarPorId(@PathVariable Integer id) {
		Lote lote = this.loteRepositorio.findOne(id);
		return lote != null ? ResponseEntity.ok(lote) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ADMIN')")
	public void remover(@PathVariable Integer id) {
		this.loteRepositorio.delete(id);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Lote> atualizar(@PathVariable Integer id, @RequestBody @Valid Lote lote) {
		Lote loteSalvo = this.loteServico.atualizar(id, lote);
		return ResponseEntity.ok(loteSalvo);
	}
	
}
