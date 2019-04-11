package br.edu.ifpb.followup.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Resposta implements Serializable {

    @EmbeddedId
    private RespostaPK pk;

    @ManyToOne
    //@MapsId("questao")
    @JoinColumn(name = "questao")
    private Questao questao;

    @ManyToOne
    @JoinColumn(name = "alternativa")
    private Alternativa alternativa;

    public Resposta() {
    }

    public RespostaPK getPk() {
        return pk;
    }

    public void setPk(RespostaPK pk) {
        this.pk = pk;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public Alternativa getAlternativa() {
        return alternativa;
    }

    public void setAlternativa(Alternativa alternativa) {
        this.alternativa = alternativa;
    }

}
