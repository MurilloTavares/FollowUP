package br.edu.ifpb.followup.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validator.nome")
public class NomeValidator implements Validator {

    private static final String NOME_REGEX = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String nome = (String) value;
                
        Matcher matcher = Pattern.compile(
                NOME_REGEX,
                Pattern.CASE_INSENSITIVE
        ).matcher(nome);
        
        if(!matcher.matches()) {
            FacesMessage msg = new FacesMessage("Nome deve conter apenas letras");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        
        if(nome.length() < 3){
            FacesMessage msg = new FacesMessage("Nome muito curto (mínimo 3 letras)");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
    
    
    
}
