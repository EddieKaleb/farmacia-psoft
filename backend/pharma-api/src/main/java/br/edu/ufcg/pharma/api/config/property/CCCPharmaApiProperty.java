package br.edu.ufcg.pharma.api.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("cccpharma")
public class CCCPharmaApiProperty {

	private String origemPermitida = "http://localhost:4200";

	public String getOrigemPermitida() {
		return origemPermitida;
	}

	public void setOrigemPermitida(String origemPermitida) {
		this.origemPermitida = origemPermitida;
	}

}
