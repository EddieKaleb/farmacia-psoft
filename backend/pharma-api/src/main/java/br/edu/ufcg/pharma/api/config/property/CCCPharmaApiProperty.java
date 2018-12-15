package br.edu.ufcg.pharma.api.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("cccpharma")
public class CCCPharmaApiProperty {

	private String origemPermitida = "localhost://localhost:8080";

	public String getOrigemPermitida() {
		return origemPermitida;
	}

	public void setOrigemPermitida(String origemPermitida) {
		this.origemPermitida = origemPermitida;
	}

}
