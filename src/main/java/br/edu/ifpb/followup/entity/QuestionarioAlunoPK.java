package br.edu.ifpb.followup.entity;

import java.io.Serializable;
import java.util.Objects;

public class QuestionarioAlunoPK implements Serializable {

    private int questionario_pk;
    private String aluno_pk;

    public QuestionarioAlunoPK() {
    }

    public QuestionarioAlunoPK(int questionario_pk, String aluno_pk) {
        this.questionario_pk = questionario_pk;
        this.aluno_pk = aluno_pk;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.questionario_pk;
        hash = 89 * hash + Objects.hashCode(this.aluno_pk);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final QuestionarioAlunoPK other = (QuestionarioAlunoPK) obj;
        if (this.questionario_pk != other.questionario_pk) {
            return false;
        }
        if (!Objects.equals(this.aluno_pk, other.aluno_pk)) {
            return false;
        }
        return true;
    }

}
