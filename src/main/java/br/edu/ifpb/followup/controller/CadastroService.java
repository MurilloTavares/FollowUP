package br.edu.ifpb.followup.controller;

import br.edu.ifpb.followup.builder.UsuarioBuilder;
import br.edu.ifpb.followup.dao.UsuarioDAO;
import br.edu.ifpb.followup.entity.Usuario;
import br.edu.ifpb.followup.factory.UsuarioBuilderFactory;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class CadastroService {
    
    @EJB
    private UsuarioDAO uDao;
    
    private String email;
    private String senha;
    private String nome;
    private String tipo = "aluno";
    
    private UIComponent info;
    
    public String cadastrar() {
        UsuarioBuilder builder = UsuarioBuilderFactory.getBuilder(tipo);
        Usuario user = builder
                .setEmail(email)
                .setNome(nome)
                .setSenha(senha)
                .build();
        uDao.cadastrar(user);
        
        String msg = "Cadastro realizado com sucesso. :)";
        MessagerJSF.msgInfo(FacesContext.getCurrentInstance(), info, msg);
        return null;
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

    public UIComponent getInfo() {
        return info;
    }

    public void setInfo(UIComponent info) {
        this.info = info;
    }
    
}
