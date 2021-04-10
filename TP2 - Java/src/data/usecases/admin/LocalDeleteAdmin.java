package data.usecases.admin;

import domain.usecases.admin.DeleteAdmin;
import domain.entities.Admin;
import domain.entities.Clinic;

public class LocalDeleteAdmin implements DeleteAdmin{
    private final Clinic clinic;
    public LocalDeleteAdmin(Clinic clinic){
        this.clinic = clinic;
    }
    @Override
    public void deleteAdmin(Admin admin){
        clinic.setAdmin(null);
    }
}
