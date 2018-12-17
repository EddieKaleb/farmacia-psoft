package br.edu.ufcg.pharma.api.servico;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ufcg.pharma.api.model.Lote;
import br.edu.ufcg.pharma.api.model.LoteSituacao;
import br.edu.ufcg.pharma.api.repositorio.LoteRepositorio;
import br.edu.ufcg.pharma.api.repositorio.LoteSituacaoRepositorio;
import br.edu.ufcg.pharma.api.servico.exception.LoteQuantidadeValorInvalidoException;

@Service
public class LoteServico {

	@Autowired
	private LoteRepositorio loteRepositorio;
	
	@Autowired
	private LoteSituacaoRepositorio loteSituacaoRepositorio;
	
	@Autowired
	private EstoqueServico estoqueServico;
	
	public Lote salvar(Lote lote) {
		LoteSituacao situacao = this.loteSituacaoRepositorio.findOne(1);
		lote.setSituacao(situacao);
		
		if (lote.getQuantidade() <= 0) {
			throw new LoteQuantidadeValorInvalidoException();
		}
		
		this.estoqueServico.salvar(lote);
		return this.loteRepositorio.save(lote);
	}
	
	public Lote atualizar(Integer id, Lote lote) {
		Lote loteSalvo = buscarLotePorId(id);
		lote.setSituacao(loteSalvo.getSituacao());
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

	public void remover(Integer id) {
		Lote loteSalvo = buscarLotePorId(id);
		loteSalvo.setQuantidade(0);
		this.estoqueServico.atualizar(loteSalvo);
		this.loteRepositorio.delete(id);
	}
	
	public void removerTodosPorProdutoId(Integer produtoId) {
		List<Lote> lotes = this.loteRepositorio.findAllByProdutoId(produtoId);
		
		for (Lote l : lotes) {
			this.loteRepositorio.delete(l.getId());
		}
	}
}
