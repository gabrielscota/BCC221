package data.usecases.schedule;

import domain.entities.Clinic;
import domain.entities.Consultation;
import domain.entities.Schedule;
import domain.usecases.schedule.AddConsultation;

public class LocalAddConsultation implements AddConsultation {
  private final Clinic clinic;

  public LocalAddConsultation(Clinic clinic) {
    this.clinic = clinic;
  }

  @Override
  public void addConsultation(Schedule schedule, Consultation consultation) {
    if (schedule != null) {
      schedule.getConsultations().add(consultation);
    }
  }
}
