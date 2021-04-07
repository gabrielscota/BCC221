package data.usecases.schedule;

import domain.entities.Consultation;
import domain.entities.Schedule;
import domain.usecases.schedule.EditConsultation;

import java.util.List;

public class LocalEditConsultation implements EditConsultation {
  private final Schedule schedule;

  public LocalEditConsultation(Schedule schedule) {
    this.schedule = schedule;
  }

  @Override
  public void editConsultation(Schedule schedule, Consultation consultation) {
    List<Consultation> consultations = schedule.getConsultations();
    if (!consultations.isEmpty()) {
      for (int i = 0; i < consultations.size(); i++) {
        if (consultations.get(i).getId() == consultation.getId()) {
          consultations.set(i, consultation);
          break;
        }
      }
    }
  }
}
