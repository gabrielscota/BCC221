#ifndef PAYMENTCONSULTATION_H_
#define PAYMENTCONSULTATION_H_

#include <string>
#include <iostream>

using namespace std;

class PaymentConsultation
{
  string id;
  double value;

public:
  PaymentConsultation(string id, double value);
  ~PaymentConsultation();

  string getId();
  double getValue();

  void setValue(double value);
};

#endif /* PAYMENTCONSULTATION_H_ */