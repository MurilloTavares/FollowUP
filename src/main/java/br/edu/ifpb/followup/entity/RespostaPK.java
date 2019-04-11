package br.edu.ifpb.followup.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RespostaPK implements Serializable {

    @Column(name = "questao", insertable = false, updatable = false)
    private int questao;
    @Column(name = "listarespondida")
    private int listaRespondida;

    public RespostaPK() {
    }
    
    public int getQuestao() {
        return questao;
    }

    public void setQuestao(int questao) {
        this.questao = questao;
    }

    public int getListaRespondida() {
        return listaRespondida;
    }

    public void setListaRespondida(int listaRespondida) {
        this.listaRespondida = listaRespondida;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.questao;
        hash = 47 * hash + this.listaRespondida;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RespostaPK other = (RespostaPK) obj;
        if (this.questao != other.questao) {
            return false;
        }
        if (this.listaRespondida != other.listaRespondida) {
            return false;
        }
        return true;
    }

}
