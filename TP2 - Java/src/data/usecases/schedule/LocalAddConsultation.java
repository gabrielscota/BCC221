package data.usecases.schedule;

import domain.entities.Consultation;
import domain.entities.Schedule;
import domain.usecases.schedule.AddConsultation;

public class LocalAddConsultation implements AddConsultation {
  private final Schedule schedule;

  public LocalAddConsultation(Schedule schedule) {
    this.schedule = schedule;
  }

  @Override
  public void addConsultation(Consultation consultation) {
    if (schedule != null) {
      schedule.getConsultations().add(consultation);
    }
  }
}
