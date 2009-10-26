package jm.livrosonline.beans;

import java.util.List;

import jm.livrosonline.entidade.Categoria;
import jm.livrosonline.entidade.Livro;
import jm.livrosonline.factory.FactoryDao;

public class LivrosHomeBean {
	
	private List<Categoria> categorias;
	private Categoria categoriaSelecionada;
	private Livro livro;
	private Integer livroIdSelecionado;
	private List<Livro> livros;
	
	public List<Categoria> getCategorias() {
		if (categorias == null) {
			categorias = FactoryDao.getLivrosDao().findAllCategoriasLivro();
		}
		return categorias;
	}
	
	public Categoria getCategoriaSelecionada() {
		return categoriaSelecionada;
	}

	public Livro getLivro() {
		return livro;
	}

	public Integer getLivroIdSelecionado() {
		return livroIdSelecionado;
	}
	
	public List<Livro> getLivros() {
		if (livros == null) {
			livros = FactoryDao.getLivrosDao().getLivrosByCategoria(categoriaSelecionada);
		}
		return livros;
	}

	public String selecionarLivro() {
		livro = FactoryDao.getLivrosDao().findById(livroIdSelecionado);
		return "visualizar";
	}
	
	public String selecionarCategoria() {
		livros = null;
		return "index";
	}

	public void setCategoriaSelecionada(Categoria categoriaSelecionada) {
		this.categoriaSelecionada = categoriaSelecionada;
	}

	public void setLivroIdSelecionado(Integer livroIdSelecionado) {
		this.livroIdSelecionado = livroIdSelecionado;
	}

}
