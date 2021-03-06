package data.usecases.orthodontist;

import domain.entities.Clinic;
import domain.entities.Orthodontist;
import domain.usecases.orthodontist.AddOrthodontist;

public class LocalAddOrthodontist implements AddOrthodontist {
  private final Clinic clinic;

  public LocalAddOrthodontist(Clinic clinic) {
    this.clinic = clinic;
  }

  @Override
  public void addOrthodontist(Orthodontist orthodontist) {
    clinic.getOrthodontists().add(orthodontist);
  }
}
