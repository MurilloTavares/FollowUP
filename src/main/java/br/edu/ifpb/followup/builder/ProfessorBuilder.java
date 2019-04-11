package br.edu.ifpb.followup.builder;

import br.edu.ifpb.followup.entity.Professor;
import br.edu.ifpb.followup.entity.Usuario;

public class ProfessorBuilder implements UsuarioBuilder{
    
    private Professor prof;

    public ProfessorBuilder() {
        this.prof = new Professor();
    }
    
    @Override
    public UsuarioBuilder setNome(String nome) {
        prof.setNome(nome);
        return this;
    }

    @Override
    public UsuarioBuilder setEmail(String email) {
        prof.setEmail(email);
        return this;
    }

    @Override
    public UsuarioBuilder setSenha(String senha) {
        prof.setSenha(senha);
        return this;
    }

    @Override
    public Usuario build() {
        return prof;
    }
    
}
