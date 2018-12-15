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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import br.edu.ufcg.pharma.api.evento.RecursoCriadoEvento;
import br.edu.ufcg.pharma.api.exceptionhandler.PharmaExceptionHandler.Erro;
import br.edu.ufcg.pharma.api.model.Venda;
import br.edu.ufcg.pharma.api.model.VendaProduto;
import br.edu.ufcg.pharma.api.repositorio.VendaRepositorio;
import br.edu.ufcg.pharma.api.servico.VendaServico;
import br.edu.ufcg.pharma.api.servico.exception.EstoqueInsuficienteException;

@RestController
@RequestMapping("/vendas")
public class VendaRecurso {
	
	@Autowired
	private VendaRepositorio vendaRepositorio;
	
	@Autowired
	private VendaServico vendaServico;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<Venda> listar() {
		return this.vendaRepositorio.findAll();
	}
	
	@PostMapping("/iniciar")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Venda> iniciarVenda(@RequestBody @Valid Venda venda, HttpServletResponse resposta) {
		Venda vendaSalva = this.vendaServico.iniciar(venda);
		publisher.publishEvent(new RecursoCriadoEvento(this, resposta, vendaSalva.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(vendaSalva);
	}
	
	@PostMapping("/finalizar/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Venda> finalizarVenda(@PathVariable Integer id, HttpServletResponse resposta) {
		Venda vendaSalva = this.vendaServico.finalizar(id);
		publisher.publishEvent(new RecursoCriadoEvento(this, resposta, vendaSalva.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(vendaSalva);
	}
	
	@PostMapping("/adicionar-produto")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<VendaProduto> adicionarProduto(@RequestBody @Valid VendaProduto produtoVenda) {
		VendaProduto vendaProdutoSalvo = this.vendaServico.adicionarProdutoVenda(produtoVenda);
		return vendaProdutoSalvo != null ? ResponseEntity.ok(vendaProdutoSalvo) : ResponseEntity.notFound().build();
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
	
	@ExceptionHandler({ EstoqueInsuficienteException.class })
	public ResponseEntity<Object> handleEstoqueInsuficienteException(EstoqueInsuficienteException ex, WebRequest request) {
		String mensagemUsr = messageSource.getMessage("recurso.estoque-insuficiente", null, LocaleContextHolder.getLocale());
		String mensagemDev =  ExceptionUtils.getRootCauseMessage(ex);
		List<Erro> erros = Arrays.asList(new Erro(mensagemUsr,mensagemDev));
		return ResponseEntity.badRequest().body(erros);
	}
}
