package br.edu.ifpb.followup.controller;

import br.edu.ifpb.followup.builder.AlunoBuilder;
import br.edu.ifpb.followup.builder.ProfessorBuilder;
import br.edu.ifpb.followup.builder.UsuarioBuilder;
import br.edu.ifpb.followup.dao.UsuarioDAO;
import br.edu.ifpb.followup.entity.Usuario;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class AuthController {

    @EJB
    private UsuarioDAO dao;

    private UsuarioBuilder builder;

    private String email;
    private String senha;
    private String nome;
    private String tipo = "aluno";

    private UIComponent infoComponent;
    private UIComponent errorComponent;

    public String autenticar() {
        Usuario user = dao.autenticar(email, senha);
        if (user == null) {
            msgErro("Email ou senha inválida");
            return null;
        }
        String type = user.getTipo();
        type = type.toLowerCase();
        SessionJSF.setParam(type, user); // ("aluno", aluno) ou ("professor", professor)
        SessionJSF.setParam("user", user); // usado para identificar se existe usuario logado
        
        String path = type;
        return path+"/home.xhtml?faces-redirect=true";
    }

    private void msgSucesso(String txt) {
        if (infoComponent == null) {
            return;
        }
        FacesMessage msg = new FacesMessage(txt);
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance()
                .addMessage(infoComponent.getClientId(), msg);
    }

    private void msgErro(String txt) {
        if (errorComponent == null) {
            return;
        }
        FacesMessage msg = new FacesMessage(txt);
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance()
                .addMessage(errorComponent.getClientId(), msg);
    }

    private UsuarioBuilder getTipoBuilder() {
        if (tipo.equals("aluno")) {
            return new AlunoBuilder();
        }
        return new ProfessorBuilder();
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public UIComponent getInfoComponent() {
        return infoComponent;
    }

    public void setInfoComponent(UIComponent infoComponent) {
        this.infoComponent = infoComponent;
    }

    public UIComponent getErrorComponent() {
        return errorComponent;
    }

    public void setErrorComponent(UIComponent errorComponent) {
        this.errorComponent = errorComponent;
    }

}
