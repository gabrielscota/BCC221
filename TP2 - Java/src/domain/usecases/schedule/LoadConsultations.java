package domain.usecases.schedule;

import domain.entities.Consultation;

import java.util.List;

public interface LoadConsultations {
  List<Consultation> loadConsultations();
}
