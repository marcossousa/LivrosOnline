package jm.livrosonline.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class EmailValidator implements Validator {

	public void validate(FacesContext arg0, UIComponent arg1, Object valor) throws ValidatorException {
		Pattern mask = Pattern.compile(".+@.+\\.[a-z]+"); 
		Matcher matcher = mask.matcher((String) valor);
		if (!matcher.matches()){
			FacesMessage message = new FacesMessage();
			message.setDetail("O e-mail é inválido");
			message.setSummary("O e-mail é inválido");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
	}
}

