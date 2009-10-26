package jm.livrosonline.dao;

import java.util.List;

import jm.livrosonline.entidade.Categoria;
import jm.livrosonline.entidade.Livro;

public interface LivroDao {
	
	List<Categoria> findAllCategoriasLivro();
	
	Livro findById(Integer id);
	
	List<Livro> getLivrosByCategoria(Categoria categoria);	
}
