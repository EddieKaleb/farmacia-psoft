package br.edu.ufcg.pharma.api.recurso;

import java.util.ArrayList;
import java.util.List;

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

	@GetMapping
	public List<Estoque> listar() {
		return estoqueRepositorio.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Estoque> buscarPorId(@PathVariable Integer id) {
		Estoque estoqueSalvo = this.estoqueRepositorio.findOne(id);
		return estoqueSalvo != null ? ResponseEntity.ok(estoqueSalvo) : ResponseEntity.notFound().build();
	}

	@GetMapping("/categoria/{id}")
	public List<Estoque> buscarPorCategoria(@PathVariable Integer id) {
		List<Estoque> estoques = this.estoqueRepositorio.findAll();
		List<Estoque> novoEstoque = new ArrayList<>();
		if (id >= 1 && id <= 4) {
			novoEstoque = filtrarPorCategoria(estoques, id);
		}
		return novoEstoque;
	}

	private List<Estoque> filtrarPorCategoria(List<Estoque> estoques, Integer id) {
		List<Estoque> novoEstoque = new ArrayList<>();
		for (int i = 0; i < estoques.size(); i++) {
			if (estoques.get(i).getProduto().getCategoria().getId() == id) {
				novoEstoque.add(estoques.get(i));
			}
		}
		return novoEstoque;

	}

	@GetMapping("/atualizar/{id}")
	public ResponseEntity<Estoque> atualizarValidade(@PathVariable Integer id) {
		Estoque estoqueSalvo = this.estoqueServico.atualizarValidadePorProdutoId(id);
		return estoqueSalvo != null ? ResponseEntity.ok(estoqueSalvo) : ResponseEntity.notFound().build();
	}

	@GetMapping("/atualizar")
	public List<Estoque> atualizarTodasValidades() {
		List<Estoque> estoques = estoqueRepositorio.findAll();
		for (Estoque e : estoques) {
			this.estoqueServico.atualizarValidadePorProdutoId(e.getProduto().getId());
		}
		return estoqueRepositorio.findAll();
	}

}