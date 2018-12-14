package br.edu.ufcg.pharma.api.servico;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ufcg.pharma.api.model.Lote;
import br.edu.ufcg.pharma.api.model.LoteSituacao;
import br.edu.ufcg.pharma.api.repositorio.LoteRepositorio;
import br.edu.ufcg.pharma.api.repositorio.LoteSituacaoRepositorio;
import br.edu.ufcg.pharma.api.repositorio.ProdutoSituacaoRepositorio;

@Service
public class LoteServico {

	@Autowired
	private LoteRepositorio loteRepositorio;
	
	@Autowired
	private LoteSituacaoRepositorio loteSituacaoRepositorio;
	
	@Autowired
	private EstoqueServico estoqueServico;
	
	public Lote salvar(Lote lote) {
		this.estoqueServico.salvar(lote);
		return this.loteRepositorio.save(lote);
	}
	
	public Lote atualizar(Integer id, Lote lote) {
		Lote loteSalvo = buscarLotePorId(id);

		BeanUtils.copyProperties(lote, loteSalvo, "id");
		this.estoqueServico.atualizar(loteSalvo);
		return this.loteRepositorio.save(loteSalvo);
	}

	private Lote buscarLotePorId(Integer id) {
		Lote loteSalvo = loteRepositorio.findOne(id);

		if (loteSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return loteSalvo;
	}

	public void atualizarSituacao(Lote lote, int loteSituacao) {
		LoteSituacao situacao = this.loteSituacaoRepositorio.findOne(loteSituacao);
		lote.setSituacao(situacao);
		this.loteRepositorio.save(lote);
	}
}
