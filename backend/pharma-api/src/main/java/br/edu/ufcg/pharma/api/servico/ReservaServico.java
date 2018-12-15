package br.edu.ufcg.pharma.api.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufcg.pharma.api.model.Reserva;
import br.edu.ufcg.pharma.api.model.Venda;
import br.edu.ufcg.pharma.api.model.VendaStatus;
import br.edu.ufcg.pharma.api.repositorio.ReservaRepositorio;
import br.edu.ufcg.pharma.api.repositorio.VendaRepositorio;
import br.edu.ufcg.pharma.api.repositorio.VendaStatusRepositorio;

@Service
public class ReservaServico {
	@Autowired
	private ReservaRepositorio reservaRepositorio;
	
	@Autowired
	private VendaStatusRepositorio vendaStatusRepositorio;
	
	@Autowired
	private VendaRepositorio vendaRepositorio;
	
	public Reserva salvar(Reserva reserva) {	
		Venda venda = this.vendaRepositorio.findOne(reserva.getVenda().getId());
		
		VendaStatus status = this.vendaStatusRepositorio.findOne(3);
		venda.setStatus(status);
		
		this.vendaRepositorio.save(venda);
		return this.reservaRepositorio.save(reserva);
	}
}
