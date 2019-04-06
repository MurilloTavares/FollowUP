package br.edu.ifpb.followup.validator;

import br.edu.ifpb.followup.entity.Alternativa;
import br.edu.ifpb.followup.entity.Questao;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validator.questao")
public class QuestaoValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Questao q = (Questao) value;
        
        if(q == null || q.quantCorretas() < 1){
            FacesMessage msg = new FacesMessage("Marque pelo menos uma alternativa como correta.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
    
}
