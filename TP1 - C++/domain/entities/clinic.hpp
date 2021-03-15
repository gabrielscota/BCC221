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
  vector<Orthodontist *> orthodontists;
  vector<Assistent *> assistents;
  vector<Patient *> patients;
  vector<Expense *> expenses;
  Receptionist *receptionist;
  Admin *admin;

public:
  Clinic();
  Clinic(string id, vector<Orthodontist *> orthodontists, vector<Assistent *> assistents, vector<Patient *> patients, vector<Expense *> expenses, Receptionist *receptionist, Admin *admin);
  ~Clinic();

  string getId();
  vector<Orthodontist *> getOrthodontists();
  vector<Assistent *> getAssistents();
  vector<Patient *> getPatients();
  vector<Expense *> getExpenses();
  Receptionist *getReceptionist();
  Admin *getAdmin();

  void setOrthodontists(vector<Orthodontist *> orthodontists);
  void setAssistents(vector<Assistent *> assistents);
  void setPatients(vector<Patient *> patients);
  void setExpenses(vector<Expense *> expenses);
  void setReceptionist(Receptionist *receptionist);
  void setAdmin(Admin *admin);
  void listOrthodontists();
};

#endif /* CLINIC_H_ */