package br.edu.ufcg.pharma.api.recurso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufcg.pharma.api.model.Estoque;
import br.edu.ufcg.pharma.api.repositorio.EstoqueRepositorio;
import br.edu.ufcg.pharma.api.servico.EstoqueServico;

@RestController
@RequestMapping("/estoques")
public class EstoqueRecurso {

	@Autowired
	private EstoqueRepositorio estoqueRepositorio;
	
	@Autowired
	private EstoqueServico estoqueServico;
	
	@GetMapping("/{id}")
	public ResponseEntity<Estoque> buscarPorId(@PathVariable Integer id) {
		Estoque estoqueSalvo = this.estoqueRepositorio.findOne(id);
		return estoqueSalvo != null ? ResponseEntity.ok(estoqueSalvo) : ResponseEntity.notFound().build();
	}
	
	@GetMapping("/atualizar/{id}")
	public ResponseEntity<Estoque> atualizarValidade(@PathVariable Integer id) {
		Estoque estoqueSalvo = this.estoqueServico.atualizarValidadePorProdutoId(id);
		return estoqueSalvo != null ? ResponseEntity.ok(estoqueSalvo) : ResponseEntity.notFound().build();
	}
	
}
