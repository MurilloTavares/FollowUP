package br.edu.ifpb.followup.dao;

import br.edu.ifpb.followup.entity.ListaDeQuestao;
import br.edu.ifpb.followup.entity.Professor;
import br.edu.ifpb.followup.entity.TipoQuestao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class QuestionarioDAO {
    
    @PersistenceContext(unitName = "followUpPU")
    private EntityManager em;
    
    public void salvar(ListaDeQuestao q){
        em.persist(q);
    }
    
    public void remover(ListaDeQuestao q){
        em.remove(em.find(ListaDeQuestao.class, q.getId()));
    }
    
    public void atualizar(ListaDeQuestao q){
        em.merge(q);
    }
    
    public ListaDeQuestao buscar(int id){
        return em.find(ListaDeQuestao.class, id);
    }
    
    public List<ListaDeQuestao> questionariosOf(Professor p){
        String sql = "SELECT q FROM Professor p, IN(p.listasdequestao) q "
                   + "WHERE p.email = :email";
        
        TypedQuery<ListaDeQuestao> query = em.createQuery(sql, ListaDeQuestao.class);
        query.setParameter("email", p.getEmail());
        return query.getResultList();
    }
    
    public List<ListaDeQuestao> questionariosOf(Professor p, TipoQuestao tipo){
        String sql = "SELECT q FROM ListaDeQuestao q "
                    +"WHERE q.professor = :prof and q.tipo = :tipo";
        
        TypedQuery<ListaDeQuestao> query = em.createQuery(sql, ListaDeQuestao.class);
        query.setParameter("prof", p);
        query.setParameter("tipo", tipo);
        return query.getResultList();
    }
    
}
