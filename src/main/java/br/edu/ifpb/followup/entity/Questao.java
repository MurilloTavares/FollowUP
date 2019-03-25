package br.edu.ifpb.followup.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
    
    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "questao")
    private List<Alternativa> alternativas;
    
    @Lob
    private String enunciado;
    
    @Enumerated(EnumType.STRING)
    private TipoQuestao tipo;

    public Questao() {
        alternativas = new ArrayList<>();
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
    
    public void addAlternativa(Alternativa alt){
        this.alternativas.add(alt);
    }
    
    public void removerAlternativa(Alternativa alt){
        this.alternativas.remove(alt);
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

    @Override
    public String toString() {
        return "Questao{" + "id=" + id + ", alternativas=" + alternativas + ", enunciado=" + enunciado + ", tipo=" + tipo + '}';
    }
    
}
