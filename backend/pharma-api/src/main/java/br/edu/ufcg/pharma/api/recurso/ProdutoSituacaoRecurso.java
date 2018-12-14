package br.edu.ufcg.pharma.api.recurso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufcg.pharma.api.model.ProdutoSituacao;
import br.edu.ufcg.pharma.api.repositorio.ProdutoSituacaoRepositorio;

@RestController
@RequestMapping("/produtos-situacoes")
public class ProdutoSituacaoRecurso {
	
	@Autowired
	private ProdutoSituacaoRepositorio produtoSituacaoRepositorio;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<ProdutoSituacao> listar() {
		return this.produtoSituacaoRepositorio.findAll();
	}
	
	
}
