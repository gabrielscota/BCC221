package data.usecases.schedule;

import domain.entities.Consultation;
import domain.entities.Schedule;
import domain.usecases.schedule.LoadConsultations;

import java.util.List;

public class LocalLoadConsultations implements LoadConsultations {
  private final Schedule schedule;

  public LocalLoadConsultations(Schedule schedule) {
    this.schedule = schedule;
  }

  @Override
  public List<Consultation> loadConsultations() {
    if (schedule != null) {
      return schedule.getConsultations();
    }
    return null;
  }
}
