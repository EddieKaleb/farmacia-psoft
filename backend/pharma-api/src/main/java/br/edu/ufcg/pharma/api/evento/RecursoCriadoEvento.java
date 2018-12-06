package br.edu.ufcg.pharma.api.evento;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

/**
 * Evento de criacao de algum Recurso
 * @author eddieklf
 */
public class RecursoCriadoEvento extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	private HttpServletResponse resposta;
	private Integer codigo;
	
	public RecursoCriadoEvento(Object source, HttpServletResponse resposta, Integer codigo) {
		super(source);
		this.resposta = resposta;
		this.codigo = codigo;
	}

	public HttpServletResponse geResposta() {
		return resposta;
	}

	public Integer getCodigo() {
		return codigo;
	}
	
}
