package br.edu.ifpb.followup.dao;

import br.edu.ifpb.followup.entity.Questao;
import br.edu.ifpb.followup.entity.TipoQuestao;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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

//    public List<Questao> questoes() {
//        CriteriaQuery<Questao> queryBuilder = builder.createQuery(Questao.class);
//        queryBuilder.select(queryBuilder.from(Questao.class));
//        
//        TypedQuery<Questao> query = em.createQuery(queryBuilder);
//        return query.getResultList();
//    }
    
//    public List<Questao> questoesOf(TipoQuestao tipo){
//        CriteriaQuery<Questao> queryBuilder = builder.createQuery(Questao.class);
//        
//        Root<Questao> root = queryBuilder.from(Questao.class);
//        Predicate equal = builder.equal(root.get("tipo"), tipo);
//        queryBuilder.select(root).where(equal);
//        
//        TypedQuery<Questao> query = em.createQuery(queryBuilder);
//        return query.getResultList();
//    }
    
}
