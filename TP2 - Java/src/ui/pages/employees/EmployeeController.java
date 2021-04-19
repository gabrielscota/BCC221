package ui.pages.employees;


import domain.entities.Assistent;
import domain.entities.Orthodontist;

public interface EmployeeController
{
  void addOrthodontistTable();
  void editOrthodontistTable();
  void deleteOrthodontistTable();
  void addAssistentTable();
  void editAssistentTable();
  void deleteAssistentTable();
  void showEmployeesTable();
}