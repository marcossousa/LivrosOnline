package jm.livrosonline.jsf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import jm.livrosonline.entidade.UnidadeFederativa;
import jm.livrosonline.factory.FactoryDao;

import org.hibernate.ObjectNotFoundException;

public class UnidadeFederativaConverter implements Converter{
	
	/**
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String str)
			throws ConverterException {
		UnidadeFederativa uf;
		try {
			Integer id = new Integer( str );
			if (id == null || id == 0) {
				return null;
			}
			uf = FactoryDao.getUnidadeFederativaDao().findById(id);
		} catch( NumberFormatException nfe ) {                
			throw new ConverterException( nfe );
		} catch (ObjectNotFoundException e) {
			throw new ConverterException("Estado não encontrado");
		}

		return uf;
	}

	/**
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object obj) throws ConverterException {
		if (obj == null) {
			return null;
		} else if (obj instanceof UnidadeFederativa) {
			UnidadeFederativa u = ((UnidadeFederativa) obj);
			return String.valueOf(u.getId());
		} else {
			return null;
		}
	}

}
