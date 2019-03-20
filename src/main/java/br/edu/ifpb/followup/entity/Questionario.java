package br.edu.ifpb.followup.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Questionario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @ManyToMany
    @JoinTable(
            name = "questionario_questao",
            joinColumns = @JoinColumn(name = "questionario"),
            inverseJoinColumns = @JoinColumn(name = "questao") 
    )
    private List<Questao> questoes;
    
    @Enumerated(EnumType.STRING)
    private TipoQuestao tipo;
    
    @OneToMany(mappedBy = "questionario")
    private List<QuestionarioAluno> questionariosDeAlunos;
    
    public Questionario() {
    }

    public Questionario(List<Questao> questoes, TipoQuestao tipo) {
        this.questoes = questoes;
        this.tipo = tipo;
    }
 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

    public TipoQuestao getTipo() {
        return tipo;
    }

    public void setTipo(TipoQuestao tipo) {
        this.tipo = tipo;
    }

    public List<QuestionarioAluno> getQuestionariosDeAlunos() {
        return questionariosDeAlunos;
    }

    public void setQuestionariosDeAlunos(List<QuestionarioAluno> questionariosDeAlunos) {
        this.questionariosDeAlunos = questionariosDeAlunos;
    }

}
