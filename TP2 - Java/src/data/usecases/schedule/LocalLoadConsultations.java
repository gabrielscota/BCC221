package data.usecases.schedule;

import domain.entities.Clinic;
import domain.entities.Consultation;
import domain.entities.Schedule;
import domain.usecases.schedule.LoadConsultations;

import java.util.List;

public class LocalLoadConsultations implements LoadConsultations {
  private final Clinic clinic;

  public LocalLoadConsultations(Clinic clinic) {
    this.clinic = clinic;
  }

  @Override
  public List<Consultation> loadConsultations(Schedule schedule) {
    if (schedule != null) {
      return schedule.getConsultations();
    }
    return null;
  }
}
