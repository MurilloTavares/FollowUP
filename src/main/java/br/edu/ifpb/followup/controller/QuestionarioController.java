package br.edu.ifpb.followup.controller;

import br.edu.ifpb.followup.dao.QuestionarioDAO;
import br.edu.ifpb.followup.entity.ListaDeQuestao;
import br.edu.ifpb.followup.entity.Professor;
import br.edu.ifpb.followup.entity.Questao;
import br.edu.ifpb.followup.entity.TipoQuestao;
import br.edu.ifpb.followup.session.SessionJSF;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

// UTILIZADO EM PAG ANTIGA
@ManagedBean
@ViewScoped
public class QuestionarioController {
    
    private Professor prof;
    
    @EJB
    private QuestionarioDAO qDao;
    private ListaDeQuestao questionario;
    
    @PostConstruct
    public void init() {
        prof = (Professor) SessionJSF.getParam("professor");
        questionario = new ListaDeQuestao(TipoQuestao.QUESTIONARIO);
    }
    
    public void addQuestao(Questao q) {
        questionario.addQuestao(q);
    }
    
    public void removerQuestao(Questao q) {
        questionario.removerQuestao(q);
    }
    
    public void salvarQuestionario() {
        prof.getListasDeQuestao().add(questionario);
        questionario.setProfessor(prof);
        qDao.salvar(questionario);
    }
    
    public List<ListaDeQuestao> listar() {
        return qDao.questionariosOf(prof, TipoQuestao.QUESTIONARIO);
    }

    // Getters e Setters
    public ListaDeQuestao getQuestionario() {
        return questionario;
    }

    public void setQuestionario(ListaDeQuestao questionario) {
        this.questionario = questionario;
    }
        
}
