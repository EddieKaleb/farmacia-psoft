package br.edu.ufcg.pharma.api.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufcg.pharma.api.model.VendaProduto;

public interface VendaProdutoRepositorio extends JpaRepository<VendaProduto, Integer>{

	public List<VendaProduto> findAllByVendaId(Integer id);
}
