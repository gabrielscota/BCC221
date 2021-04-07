package domain.usecases.schedule;

import domain.entities.Consultation;
import domain.entities.Schedule;

public interface AddConsultation {
  void addConsultation(Consultation consultation);
}
