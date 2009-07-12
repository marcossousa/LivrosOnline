package jm.livrosonline.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBUF")
public class UnidadeFederativa implements Serializable {
	
	private static final long serialVersionUID = 6373467551048395266L;
	@Id
	private int id;
	@Column(name="SIGLA", length=2)
	private String sigla;
	@Column(name="DESCRICAO")
	private String descricao;
	
	public UnidadeFederativa() { }
	
	public UnidadeFederativa(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			return true;
		} else if (obj instanceof UnidadeFederativa) {
			UnidadeFederativa temp = (UnidadeFederativa) obj;
			return temp.id == this.id;
		}
		return false;
	}

}
