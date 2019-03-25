package br.edu.ifpb.followup.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Professor extends Usuario {
    
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "professor")
    private List<Questao> questoes;
    
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "professor")
    private List<ListaDeQuestao> listasDeQuestao;

    public Professor() {
        questoes = new ArrayList<>();
        listasDeQuestao = new ArrayList<>();
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
