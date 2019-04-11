package br.edu.ifpb.followup.factory;

import br.edu.ifpb.followup.builder.AlunoBuilder;
import br.edu.ifpb.followup.builder.ProfessorBuilder;
import br.edu.ifpb.followup.builder.UsuarioBuilder;

public class UsuarioBuilderFactory {
    
    public static UsuarioBuilder getBuilder(String tipo){
        if(tipo.equalsIgnoreCase("aluno")){
            return new AlunoBuilder();
        } else if (tipo.equalsIgnoreCase("professor")) {
            return new ProfessorBuilder();
        } else return null;
    }
    
}
