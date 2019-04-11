package br.edu.ifpb.followup.controller;

import br.edu.ifpb.followup.entity.Usuario;
import br.edu.ifpb.followup.session.UserSession;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class UsuarioController {

    public String getNome() {
        Usuario user = UserSession.getUser();
        return user == null? "" : user.getNome();
    }
    
}
