package jm.livrosonline.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import static javax.persistence.EnumType.ORDINAL;
import static javax.persistence.FetchType.LAZY;

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
public class Cliente {
	public enum Sexo {FEMININO, MASCULINO};
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private long id;
	@Column(name="NOME", length=40, nullable=false)
	private String nome;
	@Column(name="SOBRENOME", length=40, nullable=false)
	private String sobrenome;
	@Column(name="CPF", length=12, nullable=false)
	private String cpf;
	@Column(name="RG", length=10, nullable=true)
	private String rg;
	@Column(name="DTNASCIMENTO", length=10, nullable=true)
	private Date dataNascimento;
	@Enumerated(ORDINAL)
	@Column(name="SEXO", length=1, nullable=false)
	private Sexo sexo;
	@Column(name="EMAIL", length=100, nullable=false)
	private String email;
	@Column(name="SENHA", length=16, nullable=false)
	private String senha;
	@Column(name="ENDERECO", length=60, nullable=false)
	private String endereco;
	@Column(name="NUMERO", length=4, nullable=false)
	private int numero;
	@Column(name="COMPLEMENTO", length=20, nullable=true)
	private String complemento;
	@Column(name="BAIRRO", length=40, nullable=false)
	private String bairro;
	@ManyToOne(targetEntity=Municipio.class, fetch=LAZY)
	@JoinColumn(name="ID_MUNICIPIO", nullable=false)
	@ForeignKey(name="FK_CLIENTE_MUNICIPIO")
	private Municipio municipio;
	@ManyToOne(targetEntity=UnidadeFederativa.class, fetch=LAZY)
	@JoinColumn(name="ID_UF", nullable=false)
	@ForeignKey(name="FK_CLIENTE_UF")
	private UnidadeFederativa unidadeFederativa;
	@Column(name="REFERENCIA_ENDERECO", length=100, nullable=true)
	private String referencia;
	@Column(name="TELEFONE", length=12, nullable=true)
	private String telefone;
	@Column(name="CELULAR", length=12, nullable=true)
	private String celular;
	
	public Cliente() { }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
	
	public UnidadeFederativa getUnidadeFederativa() {
		return unidadeFederativa;
	}
	
	public void setUnidadeFederativa(UnidadeFederativa unidadeFederativa) {
		this.unidadeFederativa = unidadeFederativa;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
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
}
