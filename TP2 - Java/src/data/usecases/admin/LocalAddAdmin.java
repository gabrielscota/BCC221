package data.usecases.admin;

import domain.usecases.admin.AddAdmin;
import domain.entities.Clinic;
import domain.entities.Admin;

public class LocalAddAdmin implements AddAdmin {
    private final Clinic clinic;
    public LocalAddAdmin(Clinic clinic){
        this.clinic = clinic;
    }
    @Override
    public void addAdmin(Admin admin){
        clinic.setAdmin(admin);
    }
}