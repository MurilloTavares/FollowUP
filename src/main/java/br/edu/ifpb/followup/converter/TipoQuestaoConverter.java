package br.edu.ifpb.followup.converter;

import br.edu.ifpb.followup.entity.TipoQuestao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("converter.tipoquestao")
public class TipoQuestaoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        for(TipoQuestao t : TipoQuestao.values()){
            if(t.getLabel().equalsIgnoreCase(value)){
                return t;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((TipoQuestao) value).getLabel();
    }
    
}
