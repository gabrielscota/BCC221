package data.usecases.receptionist;

import domain.entities.Clinic;
import domain.usecases.receptionist.DeleteReceptionist;

public class LocalDeleteReceptionist implements DeleteReceptionist {
  private final Clinic clinic;

  public LocalDeleteReceptionist(Clinic clinic) {
    this.clinic = clinic;
  }

  @Override
  public void deleteReceptionist() {
    clinic.setReceptionist(null);
  }
}
