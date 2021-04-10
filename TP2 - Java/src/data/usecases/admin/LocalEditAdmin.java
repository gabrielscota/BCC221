package data.usecases.admin;

import domain.entities.Clinic;
import domain.entities.Admin;
import domain.usecases.admin.EditAdmin;

public class LocalEditAdmin implements EditAdmin{
    private final Clinic clinic;

    public LocalEditAdmin(Clinic clinic){
        this.clinic = clinic;
    }
    @Override
    public void editAdmin(Admin admin){
        clinic.setAdmin(admin);
    }
}
