package data.usecases.assistent;

import domain.entities.Clinic;
import domain.entities.Assistent;
import domain.usecases.assistent.AddAssistent;
public class LocalAddAssistent implements AddAssistent{
    private final Clinic clinic;
    public LocalAddAssistent(Clinic clinic) {
        this.clinic = clinic;
    }

    @Override
    public  void addAssistent(Assistent assistent) {
        clinic.getAssistents().add(assistent);
    }
}
