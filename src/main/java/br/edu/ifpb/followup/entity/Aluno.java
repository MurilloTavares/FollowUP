package br.edu.ifpb.followup.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Aluno extends Usuario{
    
    @Transient
    private final UserType TYPE = UserType.ALUNO;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "aluno")
    private List<ListaRespondida> listasRespondidas;

    public Aluno() {
    }

    public List<ListaRespondida> getListasRespondidas() {
        return listasRespondidas;
    }

    public void setListasRespondidas(List<ListaRespondida> listasRespondidas) {
        this.listasRespondidas = listasRespondidas;
    }

    @Override
    public UserType getUserType() {
        return TYPE;
    }
    
}
