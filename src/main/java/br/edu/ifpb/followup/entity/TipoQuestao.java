package br.edu.ifpb.followup.entity;

public enum TipoQuestao {
    
    QUESTIONARIO ("Questinário"),
    ATIVIDADE ("Atividade");
    
    private String label;
    
    private TipoQuestao(String label){
        this.label = label;
    }
    
    public String getLabel(){
        return label;
    }
    
}
