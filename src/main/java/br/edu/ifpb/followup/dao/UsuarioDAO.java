package br.edu.ifpb.followup.dao;

import br.edu.ifpb.followup.entity.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UsuarioDAO {
    
    @PersistenceContext(unitName = "followUpPU")
    private EntityManager em;
    
    public void cadastrar(Usuario user){
        em.persist(user);
    }
    
    public Usuario autenticar(String email, String senha){
        Usuario user = em.find(Usuario.class, email);
        if(user == null || !user.getSenha().equals(senha)){
            return null;
        } else {
            return user;
        }
    }
    
    public Usuario find(String email){
        return em.find(Usuario.class, email);
    }
    
}
