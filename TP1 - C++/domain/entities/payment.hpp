#ifndef PAYMENT_H_
#define PAYMENT_H_

#include <string>
#include <iostream>

using namespace std;

class Payment
{
  string id;
  string date;
  double value;
  string description;

public:
  Payment(string id, string date, double value, string description);
  ~Payment();

  string getId();
  string getDate();
  double getValue();
  string getDescription();

  void setDate(string date);
  void setValue(double value);
  void setDescription(string description);
};

#endif /* PAYMENT_H_ */