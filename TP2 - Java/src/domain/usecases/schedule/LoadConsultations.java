package domain.usecases.schedule;

import domain.entities.Consultation;
import domain.entities.Schedule;

import java.util.List;

public interface LoadConsultations {
  List<Consultation> loadConsultations(Schedule schedule);
}
