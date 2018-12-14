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
import br.edu.ufcg.pharma.api.model.Venda;
import br.edu.ufcg.pharma.api.repositorio.VendaRepositorio;
import br.edu.ufcg.pharma.api.servico.VendaServico;

@RestController
@RequestMapping("/vendas")
public class VendaRecurso {
	
	@Autowired
	private VendaRepositorio vendaRepositorio;
	
	@Autowired
	private VendaServico vendaServico;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<Venda> listar() {
		return this.vendaRepositorio.findAll();
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Venda> criar(@RequestBody @Valid Venda venda, HttpServletResponse resposta) {
		Venda vendaSalva = this.vendaServico.salvar(venda);
		publisher.publishEvent(new RecursoCriadoEvento(this, resposta, vendaSalva.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(vendaSalva);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Venda> buscarPorId(@PathVariable Integer id) {
		Venda venda = this.vendaRepositorio.findOne(id);
		return venda != null ? ResponseEntity.ok(venda) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ADMIN')")
	public void remover(@PathVariable Integer id) {
		this.vendaRepositorio.delete(id);
	}
}
