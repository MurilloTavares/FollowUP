package br.edu.ifpb.followup.dao;

import br.edu.ifpb.followup.entity.Professor;
import br.edu.ifpb.followup.entity.Questao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProfessorDAO {
    
    @PersistenceContext(unitName = "followUpPU")
    private EntityManager em;
    
    public void atualizar(Professor prof) {
        em.merge(prof);
    }
    
    public List<Questao> questoes(Professor prof){
        prof = em.find(Professor.class, prof.getEmail());
        return prof.getQuestoes();
    }
    
}
