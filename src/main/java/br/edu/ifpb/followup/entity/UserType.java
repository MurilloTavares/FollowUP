package br.edu.ifpb.followup.entity;

public enum UserType {
    PROFESSOR ("Professor", "professor"),
    ALUNO ("Aluno", "aluno");
    
    private final String LABEL;
    private final String PATH;

    private UserType(String LABEL, String PATH) {
        this.LABEL = LABEL;
        this.PATH = PATH;
    }

    public String getLABEL() {
        return LABEL;
    }

    public String getPATH() {
        return PATH;
    }
    
}
