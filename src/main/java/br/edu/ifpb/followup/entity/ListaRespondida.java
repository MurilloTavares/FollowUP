package br.edu.ifpb.followup.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
    uniqueConstraints = @UniqueConstraint(columnNames = {"listaDeQuestao", "aluno"})
) 
public class ListaRespondida implements Serializable{
    @Id
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "listaDeQuestao")
    private ListaDeQuestao listaDeQuestao;
    
    @ManyToOne
    @JoinColumn(name = "aluno")
    private Aluno aluno;
    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "listarespondida")
    private List<Resposta> respostas;
    
    private int nota;

    public ListaRespondida() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ListaDeQuestao getListaDeQuestao() {
        return listaDeQuestao;
    }

    public void setListaDeQuestao(ListaDeQuestao listaDeQuestao) {
        this.listaDeQuestao = listaDeQuestao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
}
