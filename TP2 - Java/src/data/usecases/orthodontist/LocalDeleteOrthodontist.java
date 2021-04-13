package data.usecases.orthodontist;

import domain.entities.Orthodontist;
import domain.usecases.orthodontist.DeleteOrthodontist;
import domain.entities.Clinic;

import java.util.List;

public class LocalDeleteOrthodontist implements DeleteOrthodontist {
  private final Clinic clinic;

  public LocalDeleteOrthodontist(Clinic clinic) {
    this.clinic = clinic;
  }

  @Override
  public void deleteOrthodontist(String id) {
    List<Orthodontist> orthodontists = clinic.getOrthodontists();
    if (!orthodontists.isEmpty()) {
      for (int i = 0; i < orthodontists.size(); i++) {
        if (orthodontists.get(i).getId() == id) {
          orthodontists.remove(i);
          break;
        }
      }
    }
  }
}