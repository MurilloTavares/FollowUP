package br.edu.ifpb.followup.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Professor extends Usuario {
    
    @Transient
    private final UserType TYPE = UserType.PROFESSOR;
    
    @OneToMany(fetch = FetchType.LAZY,
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "professor")
    private List<Questao> questoes;
    
    @OneToMany(mappedBy = "professor",
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<ListaDeQuestao> listasDeQuestao;

    public Professor() {
        questoes = new ArrayList<>();
        listasDeQuestao = new ArrayList<>();
    }
    
    @Override
    public UserType getUserType() {
        return TYPE;
    }
    
    public void addQuestao(Questao q){
        questoes.add(q);
    }
    
    public void removerQuestao(Questao q){
        questoes.remove(q);
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

    public List<ListaDeQuestao> getListasDeQuestao() {
        return listasDeQuestao;
    }

    public void setListasDeQuestao(List<ListaDeQuestao> listasDeQuestao) {
        this.listasDeQuestao = listasDeQuestao;
    }

    @Override
    public String toString() {
        return "Professor{" + "questoes=" + questoes + ", listasDeQuestao=" + listasDeQuestao + '}';
    }
     
}
