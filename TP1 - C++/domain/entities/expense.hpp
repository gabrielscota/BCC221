#ifndef EXPENSE_H_
#define EXPENSE_H_

#include <string>
#include <iostream>

using namespace std;

class Expense
{
  string id;
  string description;
  string dueDate;
  string paymentDate;
  string expenseType;

public:
  Expense(string id, string description, string dueDate, string paymentDate, string expenseType);
  ~Expense();

  string getId();
  string getDescription();
  string getDueDate();
  string getPaymentDate();
  string getExpenseType();

  void setDescription(string description);
  void setDueDate(string dueDate);
  void setPaymentDate(string paymentDate);
  void setExpenseType(string expenseType);
};

#endif /* EXPENSE_H_ */