package jm.livrosonline.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TBLIVRO")
public class Livro implements Serializable{

	private static final long serialVersionUID = 1L;
	@Column(name="PUBLICACAO", length=4, nullable=false)
	private Integer anoPublicacao;
	@Column(name="AUTOR", length=50, nullable=false)
	private String autor;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CATEGORIA")
	private Categoria categoria;
	@Column(name="DESCRICAO", nullable=false)
	private String descricao;
	@Column(name="EDITORA", length=50, nullable=true)
	private String editora;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	@Column(name="IDIOMA", length=20, nullable=false)
	private String idioma;
	@Column(name="IMAGEM", nullable=true)
	private byte[] imagem;
	@Column(name="ISBN_13", length=14, nullable=true)
	private String isbn;
	@Column(name="NOME", length=50, nullable=false)
	private String nome;
	@Column(name="PAGINAS", length=5, nullable=true)
	private Integer paginas;
	@Column(name="PRECO", precision=8, scale=2, nullable=false)
	private Double preco;
	
	public Livro() {}
	
	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			return true;
		} else if (obj instanceof Livro) {
			Livro temp = (Livro) obj;
			return temp.id == this.id;
		}
		return false;
	}

	public Integer getAnoPublicacao() {
		return anoPublicacao;
	}

	public String getAutor() {
		return autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getEditora() {
		return editora;
	}

	public Integer getId() {
		return id;
	}

	public String getIdioma() {
		return idioma;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getNome() {
		return nome;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public Double getPreco() {
		return preco;
	}

	public void setAnoPublicacao(Integer anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
}
