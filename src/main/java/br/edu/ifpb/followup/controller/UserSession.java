package br.edu.ifpb.followup.controller;

import br.edu.ifpb.followup.entity.Usuario;

public class UserSession {
    
    public static Usuario getUser() {
        return (Usuario) SessionJSF.getParam("user");
    }
    
    public static void setUser(Usuario user) {
        SessionJSF.setParam("user", user);
    }
    
}
