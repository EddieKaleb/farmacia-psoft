package br.edu.ufcg.pharma.api.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufcg.pharma.api.model.LoteHistorico;

public interface LoteHistoricoRepositorio  extends JpaRepository<LoteHistorico, Integer> {


	public List<LoteHistorico> findAllByVendaIdAndLoteId(Integer vendaId, Integer loteId);

	
}
