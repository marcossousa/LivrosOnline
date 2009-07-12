package jm.livrosonline.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import jm.livrosonline.entidade.Cliente;
import jm.livrosonline.entidade.Municipio;
import jm.livrosonline.entidade.UnidadeFederativa;
import jm.livrosonline.entidade.Cliente.Sexo;
import jm.livrosonline.factory.FactoryDao;

public class ClienteBean implements Serializable{
	private static final long serialVersionUID = -1490274270335961878L;
	private List<SelectItem> municipios;
	private List<SelectItem> unidadesFederativas;
	private Cliente cliente;
	private String senhaConfirmacao;
	
	public ClienteBean() {}
	
	public String getSenhaConfirmacao() {
		return senhaConfirmacao;
	}
	
	public void setSenhaConfirmacao(String senhaConfirmacao) {
		this.senhaConfirmacao = senhaConfirmacao;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void atualizaMunicipio(ValueChangeEvent vce) {
		cliente.setUnidadeFederativa((UnidadeFederativa)vce.getNewValue());
		loadMunicipios();
	}

	public List<SelectItem> getMunicipios() {
		if (municipios == null && cliente.getUnidadeFederativa() != null) {
			loadMunicipios();
		} else if (municipios == null) {
			return new ArrayList<SelectItem>();
		}
		return municipios;
	}

	private void loadMunicipios() {
		municipios = new ArrayList<SelectItem>();
		List<Municipio> entidades = FactoryDao.getMunicipioDao().findMunicipiosByUf(cliente.getUnidadeFederativa());
		for (Municipio municipio: entidades) {
			municipios.add(new SelectItem(municipio, municipio.getDescricao()));
		}
	}

	public List<SelectItem> getUnidadesFederativas() {
		if (unidadesFederativas == null) {
			unidadesFederativas = new ArrayList<SelectItem>();
			List<UnidadeFederativa> entidades = FactoryDao.getUnidadeFederativaDao().findAll();
			for (UnidadeFederativa uf: entidades) {
				unidadesFederativas.add(new SelectItem(uf, uf.getDescricao()));
			}
		}
		
		return unidadesFederativas;
	}

	public String registrar() {
		if (!senhaConfirmacao.equals(cliente.getSenha())) {
			FacesMessage msg = new FacesMessage("A senha de confirmação informada não confere");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return "erro";
		}
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Obrigado por se registrar ao Livros Online!"));
		FactoryDao.getClienteDao().criar(cliente);
		
		return "sucesso";
	}
	
	public List<SelectItem> getOpcoesSexo() {
		List<SelectItem> itens = new ArrayList<SelectItem>();
		itens.add(new SelectItem(Sexo.FEMININO, "Feminino"));
		itens.add(new SelectItem(Sexo.MASCULINO, "Masculino"));
		return itens;
	}
}
