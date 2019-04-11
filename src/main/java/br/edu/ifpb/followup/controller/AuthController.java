package br.edu.ifpb.followup.controller;

import br.edu.ifpb.followup.dao.UsuarioDAO;
import br.edu.ifpb.followup.entity.Usuario;
import br.edu.ifpb.followup.session.UserSession;
import java.io.IOException;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class AuthController {

    @EJB
    private UsuarioDAO dao;

    private String email;
    private String senha;

    private UIComponent error;

    public void autenticar() throws IOException {
        Usuario user = dao.autenticar(email, senha);
        if (user == null) {
            String msg = "Email ou senha inválida. :(";
            MessagerJSF.msgError(FacesContext.getCurrentInstance(), error, msg );
            return;
        }
        
        UserSession.setUser(user);
        String path = user.getUserType().getPATH();
        path = "../"+path+"/home.xhtml?faces-redirect=true";
        FacesContext.getCurrentInstance().getExternalContext().redirect(path); 
    }
    
    public void logout() throws IOException {
        UserSession.invalidate();
        String path = "../user/login.xhtml";
        FacesContext.getCurrentInstance().getExternalContext().redirect(path);
    }

    // --- Getters e Setters ---
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

    public UIComponent getError() {
        return error;
    }

    public void setError(UIComponent error) {
        this.error = error;
    }

}
