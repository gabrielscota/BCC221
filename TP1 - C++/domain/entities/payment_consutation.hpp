#ifndef PAYMENTCONSUTATION_H_
#define PAYMENTCONSUTATION_H_

#include <string>
#include <iostream>

using namespace std;

class PaymentConsutation
{
  string id;
  double value;

public:
  PaymentConsutation(string id, double value);
  ~PaymentConsutation();

  string getId();
  double getValue();

  void setValue(double value);
};

#endif /* PAYMENTCONSUTATION_H_ */