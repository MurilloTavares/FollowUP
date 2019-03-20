package br.edu.ifpb.followup.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Professor extends Usuario{

    @OneToMany
    @JoinColumn(name = "professor")
    private List<Questao> questoes;
    
    @OneToMany
    @JoinColumn(name = "professor")
    private List<Questionario> questionarios;

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

    public List<Questionario> getQuestionarios() {
        return questionarios;
    }

    public void setQuestionarios(List<Questionario> questionarios) {
        this.questionarios = questionarios;
    }
    
}
