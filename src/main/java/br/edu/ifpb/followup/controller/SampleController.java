package br.edu.ifpb.followup.controller;

import br.edu.ifpb.followup.dao.SampleDAO;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class SampleController {
    
    @EJB
    private SampleDAO dao;
    
    public void init() {
        dao.init();
    }
    
}
