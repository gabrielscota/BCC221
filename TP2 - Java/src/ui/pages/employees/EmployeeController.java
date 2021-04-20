package ui.pages.employees;


import domain.entities.Assistent;
import domain.entities.Orthodontist;

public interface EmployeeController
{
  void backPage();
  void addOrthodontistTable();
  void editOrthodontistTable();
  boolean validateName();
  boolean validateUser();
  boolean validatePassword();
  boolean validateCombobox();
  void deleteOrthodontistTable();
  void addAssistentTable();
  void editAssistentTable();
  void deleteAssistentTable();
  void showEmployeesTable();
  void addEmployee();
  void populateCombobox();
}