package br.edu.ifpb.followup.builder;

import br.edu.ifpb.followup.entity.Aluno;
import br.edu.ifpb.followup.entity.Usuario;

public class AlunoBuilder implements UsuarioBuilder{
    
    private Aluno aluno;

    public AlunoBuilder() {
        this.aluno = new Aluno();
    }
    
    @Override
    public UsuarioBuilder setNome(String nome) {
        aluno.setNome(nome);
        return this;
    }

    @Override
    public UsuarioBuilder setEmail(String email) {
        aluno.setEmail(email);
        return this;
    }

    @Override
    public UsuarioBuilder setSenha(String senha) {
        aluno.setSenha(senha);
        return this;
    }

    @Override
    public Usuario build() {
        return aluno;
    }
    
}
