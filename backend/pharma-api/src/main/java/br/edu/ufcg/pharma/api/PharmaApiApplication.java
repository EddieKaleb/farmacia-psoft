package br.edu.ufcg.pharma.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.edu.ufcg.pharma.api.config.property.CCCPharmaApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(CCCPharmaApiProperty.class)
public class PharmaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PharmaApiApplication.class, args);
	}
}
