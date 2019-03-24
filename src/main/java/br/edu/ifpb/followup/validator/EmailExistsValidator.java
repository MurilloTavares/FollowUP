package br.edu.ifpb.followup.validator;

import br.edu.ifpb.followup.dao.UsuarioDAO;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@ManagedBean
@RequestScoped
public class EmailExistsValidator implements Validator {

    @EJB
    private UsuarioDAO dao;
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String email = (String) value;
        
        if(dao.find(email) != null){
            FacesMessage msg = new FacesMessage("Email já cadastrado");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }

}

