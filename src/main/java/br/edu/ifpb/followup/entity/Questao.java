package br.edu.ifpb.followup.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class Questao implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "questao")
    private List<Alternativa> alternativas = new ArrayList<>();
    
    @Lob
    private String enunciado;
    
    @Enumerated(EnumType.STRING)
    private TipoQuestao tipo;

    public Questao() {
    }

    public Questao(List<Alternativa> alternativas, String enunciado) {
        this.alternativas = alternativas;
        this.enunciado = enunciado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Alternativa> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public TipoQuestao getTipo() {
        return tipo;
    }

    public void setTipo(TipoQuestao tipo) {
        this.tipo = tipo;
    }
    
    public void addAlternativa(Alternativa alternativa) {
        this.alternativas.add(alternativa);
    }
    
    public void removerAlternativa(Alternativa alternativa){
        this.alternativas.remove(alternativa);
    }
        
}
