package data.usecases.orthodontist;

import domain.entities.Orthodontist;
import domain.entities.Schedule;
import domain.entities.Assistent;
import domain.usecases.orthodontist.EditOrthodontist;
import domain.entities.Clinic;
import java.util.List;

public class LocalEditOrthodontist implements EditOrthodontist{
    private final Clinic clinic;

    public LocalEditOrthodontist(Clinic clinic){
        this.clinic = clinic;
    }

    @Override
    public void editOrthodontist(Orthodontist orthodontist){
        List<Orthodontist> orthodontists = clinic.getOrthodontists();
        if(!orthodontists.isEmpty()){
            for(int i = 0; i<orthodontists.size(); i++){
                if(orthodontists.get(i).getId() == orthodontist.getId()){
                    orthodontists.set(i, orthodontist);
                    break;
                }
            }
        }
    }
}
