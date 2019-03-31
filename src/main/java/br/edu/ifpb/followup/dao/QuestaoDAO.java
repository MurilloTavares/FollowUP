package br.edu.ifpb.followup.dao;

import br.edu.ifpb.followup.entity.Professor;
import br.edu.ifpb.followup.entity.Questao;
import br.edu.ifpb.followup.entity.TipoQuestao;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;

@Stateless
public class QuestaoDAO {
    
    @PersistenceContext(unitName = "followUpPU")
    private EntityManager em;
    private CriteriaBuilder builder;
    
    @PostConstruct
    public void init(){
        builder = em.getCriteriaBuilder();
    }
    
    public void salvar(Questao q){
        em.persist(q);
    }
    
    public void remover(Questao questao){
        Questao q = em.find(Questao.class, questao.getId());
        em.remove(q);
    }
    
    public List<Questao> questoesOf(Professor p){
        String sql = "SELECT q FROM Professor p, IN(p.questoes) q "
                   + "WHERE p.email = :email" ;
        
        TypedQuery<Questao> query = em.createQuery(sql, Questao.class);
        query.setParameter("email", p.getEmail());
        return query.getResultList();
    }
    
    public List<Questao> questoesOf(Professor p, TipoQuestao tipo){
        String sql = "SELECT q FROM Professor p, IN(p.questoes) q "
                   + "WHERE p.email = :email and q.tipo = :tipo";
        
        TypedQuery<Questao> query = em.createQuery(sql, Questao.class);
        query.setParameter("email", p.getEmail());
        query.setParameter("tipo", tipo);
        return query.getResultList();
    }
    
}
