package jm.livrosonline.entidade;

import static javax.persistence.EnumType.ORDINAL;
import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="TBCLIENTE")
public class Cliente implements Serializable{

	public enum Sexo {FEMININO, MASCULINO}

	private static final long serialVersionUID = 1L;;
	
	@Column(name="BAIRRO", length=40, nullable=false)
	private String bairro;
	@Column(name="CELULAR", length=12, nullable=true)
	private String celular;
	@Column(name="COMPLEMENTO", length=20, nullable=true)
	private String complemento;
	@Column(name="CPF", length=12, nullable=false)
	private String cpf;
	@Column(name="DTNASCIMENTO", length=10, nullable=true)
	private Date dataNascimento;
	@Column(name="EMAIL", length=100, nullable=false)
	private String email;
	@Column(name="ENDERECO", length=60, nullable=false)
	private String endereco;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private long id;
	@ManyToOne(targetEntity=Municipio.class, fetch=LAZY)
	@JoinColumn(name="ID_MUNICIPIO", nullable=false)
	@ForeignKey(name="FK_CLIENTE_MUNICIPIO")
	private Municipio municipio;
	@Column(name="NOME", length=40, nullable=false)
	private String nome;
	@Column(name="NUMERO", length=4, nullable=false)
	private int numero;
	@Column(name="REFERENCIA_ENDERECO", length=100, nullable=true)
	private String referencia;
	@Column(name="RG", length=10, nullable=true)
	private String rg;
	@Column(name="SENHA", length=16, nullable=false)
	private String senha;
	@Enumerated(ORDINAL)
	@Column(name="SEXO", length=1, nullable=false)
	private Sexo sexo;
	@Column(name="SOBRENOME", length=40, nullable=false)
	private String sobrenome;
	@Column(name="TELEFONE", length=12, nullable=true)
	private String telefone;
	@ManyToOne(targetEntity=UnidadeFederativa.class, fetch=LAZY)
	@JoinColumn(name="ID_UF", nullable=false)
	@ForeignKey(name="FK_CLIENTE_UF")
	private UnidadeFederativa unidadeFederativa;
	
	public Cliente() { }

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			return true;
		} else if (obj instanceof Cliente) {
			Cliente temp = (Cliente) obj;
			return temp.id == this.id;
		}
		return false;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCelular() {
		return celular;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCpf() {
		return cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public String getEndereco() {
		return endereco;
	}

	public long getId() {
		return id;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public String getNome() {
		return nome;
	}

	public int getNumero() {
		return numero;
	}

	public String getReferencia() {
		return referencia;
	}

	public String getRg() {
		return rg;
	}

	public String getSenha() {
		return senha;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getTelefone() {
		return telefone;
	}

	public UnidadeFederativa getUnidadeFederativa() {
		return unidadeFederativa;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void setUnidadeFederativa(UnidadeFederativa unidadeFederativa) {
		this.unidadeFederativa = unidadeFederativa;
	}	
}
