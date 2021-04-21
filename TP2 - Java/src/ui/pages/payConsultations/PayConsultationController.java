package ui.pages.payConsultations;

import domain.usecases.schedule.AddConsultation;

public interface PayConsultationController {
  boolean validateValue();
  boolean validatePatientName();
  void addPaidConsultation();
  void showConsultationsTable();
  void populateComboboxConsultations();
  void populateComboboxOrthodontist();
  void populateComboboxPatients();
  void backPage();
}
