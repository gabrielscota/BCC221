package data.usecases.receptionist;

import domain.entities.Clinic;
import domain.entities.Receptionist;
import domain.usecases.receptionist.EditReceptionist;

public class LocalEditReceptionist implements EditReceptionist {
  private final Clinic clinic;

  public LocalEditReceptionist(Clinic clinic) {
    this.clinic = clinic;
  }

  @Override
  public void editReceptionist(Receptionist receptionist) {
    clinic.setReceptionist(receptionist);
  }
}
