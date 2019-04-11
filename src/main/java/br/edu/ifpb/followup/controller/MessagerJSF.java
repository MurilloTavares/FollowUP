package br.edu.ifpb.followup.controller;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

public class MessagerJSF {
    
    public static boolean msgError(FacesContext ctx, UIComponent comp, String msg){
        return msg(ctx, FacesMessage.SEVERITY_ERROR, comp, msg);
    }
    
    public static boolean msgInfo(FacesContext ctx, UIComponent comp, String msg){
        return msg(ctx, FacesMessage.SEVERITY_INFO, comp, msg);
    }
    
    public static boolean msg(
            FacesContext ctx,
            FacesMessage.Severity severity,
            UIComponent comp, String msg){
        
        if(comp == null) return false;
        ctx.addMessage(
                comp.getClientId(),
                new FacesMessage(severity, msg, null));
        return true;
    }
    
}
