package data.usecases.orthodontist;

import domain.entities.Orthodontist;
import domain.entities.Schedule;
import domain.entities.Assistent;
import domain.usecases.orthodontist.EditOrthododhontist;

public class LocalEditOrthodontist implements EditOrthododhontist{
    private final Clinic clinic;

    public LocalEditOrthodontist(Clinic clinic){
        this.clinic = clinic;
    }

    @Override
    public void editOrthododhontist(Orthodontist orthodontist){
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
