package jm.livrosonline.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBCATEGORIA")
public class Categoria implements Serializable{
	private static final long serialVersionUID = 1L;
	@Column(name="DESCRICAO", length=30, nullable=false)
	private String descricao;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private long id;
	
	public Categoria() {}
	
	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			return true;
		} else if (obj instanceof Categoria) {
			Categoria temp = (Categoria) obj;
			return temp.id == this.id;
		}
		return false;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public long getId() {
		return id;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setId(long id) {
		this.id = id;
	}
}
