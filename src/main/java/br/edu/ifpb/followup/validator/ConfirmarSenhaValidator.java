package br.edu.ifpb.followup.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validator.confirmarSenha")
public class ConfirmarSenhaValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        
        String senha = value.toString();
        
        UIInput uiInputConfirmPassword = (UIInput) component.getAttributes().get("confSenha");
	String confSenha = uiInputConfirmPassword.getSubmittedValue().toString();
                
        if (senha == null || confSenha == null) {
            return; // Deixa o validador Required funcionar
        }
        
        if (senha.length()<4) {
            FacesMessage msg = new FacesMessage("Senha muito curta (mínimo 4 caracteres)");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

        if (!senha.equals(confSenha)) {
            FacesMessage msg = new FacesMessage("Senhas diferentes");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
    
}
