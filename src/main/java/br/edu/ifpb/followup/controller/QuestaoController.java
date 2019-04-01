package br.edu.ifpb.followup.controller;

import br.edu.ifpb.followup.dao.QuestaoDAO;
import br.edu.ifpb.followup.entity.Alternativa;
import br.edu.ifpb.followup.entity.Professor;
import javax.faces.bean.ManagedBean;
import br.edu.ifpb.followup.entity.Questao;
import br.edu.ifpb.followup.entity.TipoQuestao;
import br.edu.ifpb.followup.session.SessionJSF;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class QuestaoController implements Serializable{
    
    @EJB
    private QuestaoDAO qDao;
    
    private Questao questao = new Questao();
    
    public void novaAlternativa() {
        questao.addAlternativa(new Alternativa());
    }

    public void removerAlternativa(Alternativa alt) {
        questao.removerAlternativa(alt);
    }
    
    public List<Questao> questoesQuestionario() {
        return questoesOf(TipoQuestao.QUESTIONARIO);
    }
    
    public List<Questao> questoesOf(TipoQuestao tipo){
        Professor p = (Professor) SessionJSF.getParam("professor");
        return qDao.questoesOf(p, tipo);
    }
    
    // Getters e Setters
    public List<Alternativa> getAlternativas(){
        return questao.getAlternativas();
    }
    
    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }
    
    public TipoQuestao[] getTipos() {
        return TipoQuestao.values();
    }
    
}
