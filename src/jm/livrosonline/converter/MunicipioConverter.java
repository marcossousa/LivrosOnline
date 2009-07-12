package jm.livrosonline.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import jm.livrosonline.entidade.Municipio;
import jm.livrosonline.factory.FactoryDao;

import org.hibernate.ObjectNotFoundException;

public class MunicipioConverter implements Converter{
	
	/**
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String str)
			throws ConverterException {
		Municipio uf;
		try {
			Integer id = new Integer( str );
			if (id == null || id == 0) {
				return null;
			}
			uf = FactoryDao.getMunicipioDao().findById(id);
		} catch( NumberFormatException nfe ) {                
			throw new ConverterException( nfe );
		} catch (ObjectNotFoundException e) {
			throw new ConverterException("Município não encontrado");
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
		} else if (obj instanceof Municipio) {
			Municipio u = ((Municipio) obj);
			return String.valueOf(u.getId());
		} else {
			return null;
		}
	}

}
