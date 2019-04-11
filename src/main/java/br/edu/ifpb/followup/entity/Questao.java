package br.edu.ifpb.followup.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
class Questao implements Serializable {
    
    @Id
    private int id;
    
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "questao")
    private List<Alternativa> alternativas;
    
    @Lob
    private String enunciado;
    
    @Enumerated(EnumType.STRING)
    private TipoQuestao tipo;

    public Questao() {
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
    
}
