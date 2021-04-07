package data.usecases.schedule;

import domain.entities.Clinic;
import domain.entities.Consultation;
import domain.entities.Schedule;
import domain.usecases.schedule.DeleteConsultation;

import java.util.List;

public class LocalDeleteConsultation implements DeleteConsultation {
  private final Clinic clinic;

  public LocalDeleteConsultation(Clinic clinic) {
    this.clinic = clinic;
  }

  @Override
  public void deleteConsultation(Schedule schedule, String id) {
    List<Consultation> consultations = schedule.getConsultations();
    if (!consultations.isEmpty()) {
      for (int i = 0; i < consultations.size(); i++) {
        if (consultations.get(i).getId() == id) {
          consultations.remove(i);
          break;
        }
      }
    }
  }
}
