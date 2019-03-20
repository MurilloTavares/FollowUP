package br.edu.ifpb.followup.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(QuestionarioAlunoPK.class)
public class QuestionarioAluno implements Serializable {
    
    @Id
    @Column(name = "questionario", insertable = false, updatable = false)
    private int questionario_pk;
    @Id
    @Column(name = "aluno", insertable = false, updatable = false)
    private String aluno_pk;
    
    @ManyToOne
    @JoinColumn(name = "questionario")
    private Questionario questionario;
    
    @ManyToOne
    @JoinColumn(name = "aluno")
    private Aluno aluno;
    
    private int nota;

    public QuestionarioAluno() {
    }

    public Questionario getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getQuestionario_pk() {
        return questionario_pk;
    }

    public void setQuestionario_pk(int questionario_pk) {
        this.questionario_pk = questionario_pk;
    }

    public String getAluno_pk() {
        return aluno_pk;
    }

    public void setAluno_pk(String aluno_pk) {
        this.aluno_pk = aluno_pk;
    }
    
}
