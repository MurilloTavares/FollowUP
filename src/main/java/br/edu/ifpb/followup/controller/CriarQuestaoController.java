package br.edu.ifpb.followup.controller;

import br.edu.ifpb.followup.dao.QuestaoDAO;
import br.edu.ifpb.followup.entity.Alternativa;
import br.edu.ifpb.followup.entity.Professor;
import br.edu.ifpb.followup.entity.Questao;
import br.edu.ifpb.followup.entity.TipoQuestao;
import br.edu.ifpb.followup.session.UserSession;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class CriarQuestaoController {
    
    @EJB
    private QuestaoDAO qDao;
    private Questao questao;
    private Alternativa correta;
    
    private UIComponent info;
    
    @PostConstruct
    public void init() {
        novaQuestao();
    }
    
    public void novaQuestao() {
        questao = new Questao();
        for(int i=0; i<3; i++){
            novaAlternativa();
        }
    }
    
    public void novaAlternativa() {
        questao.addAlternativa(new Alternativa());
    }
    
    public void removerAlternativa(Alternativa a){
        questao.removerAlternativa(a);
    }
    
    public void salvar() {
        Professor prof = (Professor) UserSession.getUser();
        qDao.salvar(questao, prof);
        novaQuestao();
        
        String msg = "Questão salva !";
        MessagerJSF.msgInfo(FacesContext.getCurrentInstance(), info, msg);
    }
    
    public List<TipoQuestao> getTipos(){
        return Arrays.asList(TipoQuestao.values());
    }
        
    // Getters e Setters
    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public UIComponent getInfo() {
        return info;
    }

    public void setInfo(UIComponent info) {
        this.info = info;
    }

    public Alternativa getCorreta() {
        return correta;
    }

    public void setCorreta(Alternativa correta) {
        this.correta = correta;
    }

}
