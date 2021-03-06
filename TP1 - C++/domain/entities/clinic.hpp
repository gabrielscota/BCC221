#ifndef CLINIC_H_
#define CLINIC_H_

#include <string>
#include <iostream>
#include <vector>
#include "orthodontist.hpp"
#include "time_sheet.hpp"
#include "patient.hpp"
#include "expense.hpp"
#include "receptionist.hpp"
#include "admin.hpp"

using namespace std;

class Clinic
{
  string id;
  vector<Orthodontist> orthodontists;
  vector<Assistent> assistents;
  vector<Patient> patients;
  vector<Expense> expenses;
  vector<PaymentConsultation> payments;
  Receptionist receptionist;
  User loggedUser;
  Admin admin;

public:
  Clinic();
  Clinic(string id, vector<Orthodontist> orthodontists, vector<Assistent> assistents, vector<Patient> patients, vector<Expense> expenses, Receptionist receptionist, Admin admin);
  Clinic(string id, Receptionist receptionist, Admin admin);
  ~Clinic();

  string getId();


  vector<Orthodontist> getOrthodontists();
  Orthodontist getOrthodontist(int index);
  vector<Assistent> getAssistents();
  Assistent getAssistent(int index);
  vector<Patient> getPatients();
  vector<Expense> getExpenses();
  Receptionist getReceptionist();
  Admin getAdmin();
  User getLoggedUser();
  vector<PaymentConsultation> getPayments();

  void setLoggedUser(User loggedUser);
  void setOrthodontists(vector<Orthodontist> orthodontists);
  void setOrthodontist(Orthodontist orthodontist, int index);
  void setAssistents(vector<Assistent> assistents);
  void setPatients(vector<Patient> patients);
  void setExpenses(vector<Expense> expenses);
  void setReceptionist(Receptionist receptionist);
  void setAdmin(Admin admin);
  void deleteConsulta(int indexOrtho, int index);
  void clinicMenu();
  void addConsultation(Consultation consultation, int index);
  void listOrthodontists();
  void listAssistents();
  void createConsultation(int indexOrtho);
  void editarConsulta(int indexOrtho, int index);
  void printReceptionist();
  void displaySchedule(int index);
  void payExpense();
  void receiveConsultation();
};

#endif /* CLINIC_H_ */