package br.edu.ifpb.followup.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ListaDeQuestao implements Serializable{
    
    @Id
    @GeneratedValue
    private int id;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "questao_lista",
            joinColumns = @JoinColumn(name = "lista"),
            inverseJoinColumns = @JoinColumn(name = "questao"))
    private List<Questao> questoes;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "listaDeQuestao")
    private List<ListaRespondida> gabaritos;
    
    @Enumerated(EnumType.STRING)
    private TipoQuestao tipo;
    
    @ManyToOne
    @JoinColumn(name = "professor")
    private Professor professor;
    
    private String titulo;

    public ListaDeQuestao() {
        questoes = new ArrayList<>();
        gabaritos = new ArrayList<>();
    }

    public ListaDeQuestao(TipoQuestao tipo) {
        this();
        this.tipo = tipo;
    }

    public void addQuestao(Questao q) {
        questoes.add(q);
    }
    
    public void removerQuestao(Questao q) {
        questoes.remove(q);
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

    public List<ListaRespondida> getGabaritos() {
        return gabaritos;
    }

    public void setGabaritos(List<ListaRespondida> gabaritos) {
        this.gabaritos = gabaritos;
    }

    public TipoQuestao getTipo() {
        return tipo;
    }

    public void setTipo(TipoQuestao tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
        
}
