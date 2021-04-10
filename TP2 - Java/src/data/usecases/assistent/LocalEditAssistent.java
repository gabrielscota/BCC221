package data.usecases.assistent;

import domain.entities.Clinic;
import domain.entities.Assistent;
import domain.usecases.assistent.EditAssistent;
import java.util.List;

public class LocalEditAssistent implements EditAssistent {
    private final Clinic clinic;
    public LocalEditAssistent(Clinic clinic){
        this.clinic = clinic;
    }
    @Override
    public void editAssistent(Clinic clinic, Assistent assistent){
        List<Assistent> assistents = clinic.getAssistents();
        if(!assistents.isEmpty()){
            for(int i = 0; i < assistents.size(); i++){
                if(assistents.get(i).getId() == assistent.getId()){
                    assistents.set(i, assistent);
                }
            }
        }
    }
}
