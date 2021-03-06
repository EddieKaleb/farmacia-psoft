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
import br.edu.ufcg.pharma.api.model.Categoria;
import br.edu.ufcg.pharma.api.repositorio.CategoriaRepositorio;
import br.edu.ufcg.pharma.api.servico.CategoriaServico;

@RestController
@RequestMapping("/categorias")
public class CategoriaRecurso {

	@Autowired
	private CategoriaRepositorio categoriaRepositorio;

	@Autowired
	private CategoriaServico categoriaServico;
	
	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Categoria> listar() {
		return categoriaRepositorio.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Categoria> criar(@RequestBody @Valid Categoria categoria, HttpServletResponse resposta) {
		Categoria categoriaSalva = this.categoriaRepositorio.save(categoria);
		publisher.publishEvent(new RecursoCriadoEvento(this, resposta, categoriaSalva.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> buscarPorId(@PathVariable Integer id) {
		Categoria categoria = this.categoriaRepositorio.findOne(id);
		return categoria != null ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Integer id) {
		this.categoriaRepositorio.delete(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Categoria> atualizar(@PathVariable Integer id, @RequestBody @Valid Categoria categoria) {
		Categoria categoriaSalva = this.categoriaServico.atualizar(id, categoria);
		return ResponseEntity.ok(categoriaSalva);
	}
	
}
