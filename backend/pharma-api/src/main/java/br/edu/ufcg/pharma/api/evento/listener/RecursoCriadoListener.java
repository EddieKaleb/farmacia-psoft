package br.edu.ufcg.pharma.api.evento.listener;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.ufcg.pharma.api.evento.RecursoCriadoEvento;

/**
 * Listener para adicionar o header Location.
 * @author eddieklf
 */
@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvento>{

	@Override
	public void onApplicationEvent(RecursoCriadoEvento recursoCriadoEvento) {
		HttpServletResponse resp = recursoCriadoEvento.geResposta();
		
		Integer codigo = recursoCriadoEvento.getCodigo();
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(codigo).toUri();
		
		resp.setHeader("Location", uri.toString());
	}

}
