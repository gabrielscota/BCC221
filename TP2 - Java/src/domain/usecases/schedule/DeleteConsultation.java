package domain.usecases.schedule;

import domain.entities.Schedule;

public interface DeleteConsultation {
  void deleteConsultation(Schedule schedule, String id);
}
