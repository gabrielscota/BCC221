#ifndef CONSUTATION_H_
#define CONSUTATION_H_

#include <string>
#include <iostream>

#include "patient.hpp"
#include "payment_consutation.hpp"

using namespace std;

class Consutation
{
  string id;
  Patient *patient;
  string date;
  string description;
  PaymentConsutation *paymentConsutation;

public:
  Consutation(string id, Patient *patient, string date, string description, PaymentConsutation paymentConsutation);
  ~Consutation();

  string getId();
  Patient *getPatient();
  string getDate();
  string getDescription();
  PaymentConsutation *getPaymentConsutation();

  void setPatient(Patient *patient);
  void setDate(string date);
  void setDescription(string description);
  void setPaymentConsutation(PaymentConsutation *paymentConsutation);
};

#endif /* CONSUTATION_H_ */