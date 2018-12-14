package br.edu.ufcg.pharma.api.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufcg.pharma.api.model.Venda;
import br.edu.ufcg.pharma.api.model.VendaStatus;
import br.edu.ufcg.pharma.api.repositorio.VendaRepositorio;
import br.edu.ufcg.pharma.api.repositorio.VendaStatusRepositorio;

@Service
public class VendaServico {

	@Autowired
	private VendaRepositorio vendaRepositorio;
	
	@Autowired
	private VendaStatusRepositorio vendaStatusRepositorio;
	
	public Venda salvar(Venda venda) {
		VendaStatus status = this.vendaStatusRepositorio.findOne(1);
		venda.setStatus(status);
		
		return this.vendaRepositorio.save(venda);
	}
	
	public void deletar(Integer id) {
		Venda venda = this.vendaRepositorio.findOne(id);
		VendaStatus status = this.vendaStatusRepositorio.findOne(2);
		venda.setStatus(status);
	}
}
