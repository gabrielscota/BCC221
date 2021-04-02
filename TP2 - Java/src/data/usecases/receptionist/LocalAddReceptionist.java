package data.usecases.receptionist;

import domain.entities.Clinic;
import domain.entities.Receptionist;
import domain.usecases.receptionist.AddReceptionist;

public class LocalAddReceptionist implements AddReceptionist {
    private final Clinic clinic;

    public LocalAddReceptionist(Clinic clinic) {
        this.clinic = clinic;
    }

    @Override
    public void addReceptionist(Receptionist receptionist) {
        clinic.setReceptionist(receptionist);
    }
}
