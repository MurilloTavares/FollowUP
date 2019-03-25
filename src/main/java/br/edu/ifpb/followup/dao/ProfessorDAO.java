package br.edu.ifpb.followup.dao;

import br.edu.ifpb.followup.entity.Professor;
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
    
}
