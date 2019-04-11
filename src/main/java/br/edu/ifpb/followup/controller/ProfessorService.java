package br.edu.ifpb.followup.controller;

import br.edu.ifpb.followup.entity.Professor;
import br.edu.ifpb.followup.dao.ProfessorDAO;
import br.edu.ifpb.followup.entity.ListaDeQuestao;
import br.edu.ifpb.followup.entity.Questao;
import br.edu.ifpb.followup.session.SessionJSF;
import br.edu.ifpb.followup.session.UserSession;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ProfessorService {
    
    @EJB
    private ProfessorDAO pDao;
    private Professor prof;
    
    @PostConstruct
    public void init() {
        prof = (Professor) UserSession.getUser();
    }
    
    public List<Questao> questoes(){
        return pDao.questoes(prof);
    }
            
}
