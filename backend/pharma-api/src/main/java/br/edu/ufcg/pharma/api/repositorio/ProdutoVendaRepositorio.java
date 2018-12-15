package br.edu.ufcg.pharma.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufcg.pharma.api.model.VendaProduto;


public interface ProdutoVendaRepositorio  extends JpaRepository<VendaProduto, Integer>{

}
