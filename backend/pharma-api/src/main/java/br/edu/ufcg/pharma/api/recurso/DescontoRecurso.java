package br.edu.ufcg.pharma.api.recurso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufcg.pharma.api.model.Desconto;
import br.edu.ufcg.pharma.api.repositorio.DescontoRepositorio;

@RestController
@RequestMapping("/descontos")
public class DescontoRecurso {

	@Autowired
	private DescontoRepositorio descontoRepositorio;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<Desconto> listar() {
		return this.descontoRepositorio.findAll();
	}
	
}
