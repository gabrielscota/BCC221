package data.usecases.orthodontist;

import domain.entities.Orthodontist;
import domain.entities.Schedule;
import domain.entities.Assistent;
import domain.usecases.orthodontist.DeleteOrthodontist;

import java.util.List;

public class LocalDeleteOrthodontist implements DeleteOrthodontist{
    private final Orthodontist orthodontist;

    public LocalDeleteOrthodontist(Clinic clinic){
        this.clinic = clinic;
    }

    @Override
    public void deleteOrthodontist(String id){
        List<Orthodontist> orthodontists = clinic.getOrthodontists();
        if(!orthodontist.isEmpty()){
            for(int i = 0; i<orthodontist.size(); i++){
                if(orthodontists.get(i).getId() == id){
                    orthodontists.remove(i);
                    break;
                }
            }
        }
    }
}