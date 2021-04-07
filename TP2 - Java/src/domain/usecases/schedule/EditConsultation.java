package domain.usecases.schedule;

import domain.entities.Consultation;
import domain.entities.Schedule;

public interface EditConsultation {
  void editConsultation(Schedule schedule, Consultation consultation);
}
