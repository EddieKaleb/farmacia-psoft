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
import br.edu.ufcg.pharma.api.model.Produto;
import br.edu.ufcg.pharma.api.repositorio.ProdutoRepositorio;
import br.edu.ufcg.pharma.api.servico.ProdutoServico;

@RestController
@RequestMapping("/produtos")
public class ProdutoRecurso {

	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	@Autowired
	private ProdutoServico produtoServico;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Produto> listar() {
		return produtoRepositorio.findAll();
	}
	
	@GetMapping("/categoria/{id}")
	public List<Produto> listarPorCategoria(@PathVariable Integer id) {
		return produtoRepositorio.findAllByCategoriaId(id);
	}
	
	@PostMapping
	public ResponseEntity<Produto> criar(@RequestBody @Valid Produto produto, HttpServletResponse resposta) {
		Produto produtoSalvo = this.produtoRepositorio.save(produto);
		publisher.publishEvent(new RecursoCriadoEvento(this, resposta, produtoSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscarPorId(@PathVariable Integer id) {
		Produto produto = this.produtoRepositorio.findOne(id);
		return produto != null ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Integer id) {
		this.produtoRepositorio.delete(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable Integer id, @RequestBody @Valid Produto produto) {
		Produto produtoSalvo = this.produtoServico.atualizar(id, produto);
		return ResponseEntity.ok(produtoSalvo);
	}
	
	
}
