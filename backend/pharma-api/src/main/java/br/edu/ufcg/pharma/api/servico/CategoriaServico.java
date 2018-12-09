package br.edu.ufcg.pharma.api.servico;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ufcg.pharma.api.model.Categoria;
import br.edu.ufcg.pharma.api.repositorio.CategoriaRepositorio;

@Service
public class CategoriaServico {

	@Autowired
	CategoriaRepositorio categoriaRepositorio;

	public Categoria atualizar(Integer id, Categoria categoria) {
		Categoria categoriaSalva = categoriaRepositorio.findOne(id);

		if (categoriaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}

		BeanUtils.copyProperties(categoria, categoriaSalva, "id");
		return categoriaRepositorio.save(categoriaSalva);
	}
}
