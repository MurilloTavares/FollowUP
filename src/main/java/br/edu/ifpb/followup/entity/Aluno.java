package br.edu.ifpb.followup.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Aluno extends Usuario{
    
    @OneToMany(mappedBy = "aluno")
    private List<QuestionarioAluno> questionarios;

    public List<QuestionarioAluno> getNotas() {
        return questionarios;
    }

    public void setNotas(List<QuestionarioAluno> questionarios) {
        this.questionarios = questionarios;
    }
    
}
