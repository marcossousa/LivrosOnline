package jm.livrosonline.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import static javax.persistence.FetchType.LAZY;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="TBMUNICIPIO")
public class Municipio implements Serializable {
	
	private static final long serialVersionUID = 6373467551048395266L;
	@Id
	private int id;
	@Column(name="DESCRICAO")
	private String descricao;
	@ManyToOne(targetEntity=UnidadeFederativa.class, fetch=LAZY)
	@JoinColumn(name="ID_UF")
	@ForeignKey(name="FK_MUNICIPIO_UF")
	private UnidadeFederativa unidadeFederativa;
	
	public Municipio() { }
	
	public Municipio(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public UnidadeFederativa getUnidadeFederativa() {
		return unidadeFederativa;
	}

	public void setUnidadeFederativa(UnidadeFederativa unidadeFederativa) {
		this.unidadeFederativa = unidadeFederativa;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			return true;
		} else if (obj instanceof Municipio) {
			Municipio temp = (Municipio) obj;
			return temp.id == this.id;
		}
		return false;
	}

}
