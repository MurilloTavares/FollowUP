package br.edu.ifpb.followup.builder;

import br.edu.ifpb.followup.entity.Usuario;

public interface UsuarioBuilder {
    public UsuarioBuilder setNome(String nome);
    public UsuarioBuilder setEmail(String email);
    public UsuarioBuilder setSenha(String senha);
    public Usuario build();
}
