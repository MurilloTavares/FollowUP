package br.edu.ifpb.followup.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SampleDAO {
    
    @PersistenceContext(unitName = "followUpPU")
    private EntityManager em;
    
    public void init() {
    }
    
}
