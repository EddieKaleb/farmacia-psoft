package br.edu.ufcg.pharma.api.servico;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ufcg.pharma.api.model.Lote;
import br.edu.ufcg.pharma.api.repositorio.LoteRepositorio;

@Service
public class LoteServico {

	@Autowired
	private LoteRepositorio loteRepositorio;
	
	public Lote atualizar(Integer id, Lote lote) {
		Lote loteSalvo = buscarCategoriaPorId(id);

		BeanUtils.copyProperties(lote, loteSalvo, "id");
		return loteRepositorio.save(loteSalvo);
	}

	private Lote buscarCategoriaPorId(Integer id) {
		Lote loteSalvo = loteRepositorio.findOne(id);

		if (loteSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return loteSalvo;
	}

	
	
}
