package br.edu.ufcg.pharma.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufcg.pharma.api.model.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer> {

}
