package data.usecases.assistent;

import domain.entities.Clinic;
import java.util.List;
import domain.entities.Assistent;
import domain.usecases.assistent.DeleteAssistent;
public class LocalDeleteAssistent implements DeleteAssistent{
    private final Clinic clinic;
    public LocalDeleteAssistent(Clinic clinic){
        this.clinic = clinic;
    }
    @Override
    public void deleteAssistent(String id){
        List<Assistent>  assistents = clinic.getAssistents();
        if(!assistents.isEmpty()){
            for(int i = 0; i < assistents.size(); i ++){
                if(assistents.get(i).getId() == id){
                    assistents.remove(i);
                    break;
                }
            }
        }
    }
}
