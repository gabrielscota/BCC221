#ifndef EMPLOYEE_H_
#define EMPLOYEE_H_

#include <string>
#include <iostream>
#include <vector>

#include "user.hpp"
#include "time_sheet.hpp"
#include "payment.hpp"

using namespace std;

class Employee : public User
{
  TimeSheet *timeSheet;
  vector<Payment *> payments;

public:
  Employee(string id, TimeSheet *timeSheet, vector<Payment *> payments);
  ~Employee();

  string getId();
  TimeSheet *getTimeSheet();
  vector<Payment *> getPayments();

  void setTimeSheet(TimeSheet *timeSheet);
  void setPayments(vector<Payment *> payments);
};

#endif /* EMPLOYEE_H_ */