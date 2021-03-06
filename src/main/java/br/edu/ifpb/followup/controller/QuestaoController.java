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

// UTILIZADO EM PAG ANTIGA
@ManagedBean
@ViewScoped
public class QuestaoController implements Serializable{
    
    @EJB
    private QuestaoDAO qDao;
    
    private Questao questao = new Questao();
    
}
