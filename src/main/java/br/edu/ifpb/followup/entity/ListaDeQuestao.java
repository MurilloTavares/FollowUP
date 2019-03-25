package br.edu.ifpb.followup.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class ListaDeQuestao implements Serializable{
    
    @Id
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

    public ListaDeQuestao() {
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
    
}
