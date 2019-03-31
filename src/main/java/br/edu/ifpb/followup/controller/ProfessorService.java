package br.edu.ifpb.followup.controller;

import br.edu.ifpb.followup.entity.Professor;
import br.edu.ifpb.followup.dao.ProfessorDAO;
import br.edu.ifpb.followup.entity.ListaDeQuestao;
import br.edu.ifpb.followup.entity.Questao;
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
    private Professor sessionProf;
    
    @PostConstruct
    public void init() {
        sessionProf = (Professor) SessionJSF.getParam("professor");
    }
    
    public void addQuestao(Questao q){
        sessionProf.getQuestoes().add(q);
        pDao.atualizar(sessionProf);
    }
    
    public void remover(Questao q){
        sessionProf.removerQuestao(q);
        pDao.atualizar(sessionProf);
    }
    
    public List<Questao> questoes(){
        return sessionProf.getQuestoes() ;
    }
            
}
