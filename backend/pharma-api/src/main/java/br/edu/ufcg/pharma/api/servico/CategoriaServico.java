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
		Categoria categoriaSalva = buscarCategoriaPorId(id);

		BeanUtils.copyProperties(categoria, categoriaSalva, "id");
		return categoriaRepositorio.save(categoriaSalva);
	}

	public void atualizarNome(Integer id, String nome) {
		Categoria categoriaSalva = buscarCategoriaPorId(id);
		categoriaSalva.setNome(nome);
		this.categoriaRepositorio.save(categoriaSalva);
	}
	
	private Categoria buscarCategoriaPorId(Integer id) {
		Categoria categoriaSalva = categoriaRepositorio.findOne(id);

		if (categoriaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return categoriaSalva;
	}
}
