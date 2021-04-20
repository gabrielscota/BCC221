package ui.pages.schedules;

import domain.entities.Consultation;
import domain.entities.Orthodontist;

import java.util.List;

public interface SchedulesController {
  void backPage();
  void populateCombobox();
  void updateTable(List<Orthodontist> orthodontists);
  void addConsultation();
  boolean validateCombobox();
  boolean validatePatientName();
  boolean validateDate();
  boolean validateDescription();
}
