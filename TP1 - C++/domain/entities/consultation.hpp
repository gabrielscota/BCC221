#ifndef CONSULTATION_H_
#define CONSULTATION_H_

#include <string>
#include <iostream>

#include "patient.hpp"
#include "payment_consultation.hpp"

using namespace std;

class Consultation
{
  string id;
  Patient *patient;
  string date;
  string description;
  PaymentConsultation *paymentConsultation;

public:
  Consultation(string id, Patient *patient, string date, string description, PaymentConsultation paymentConsultation);
  ~Consultation();

  string getId();
  Patient *getPatient();
  string getDate();
  string getDescription();
  PaymentConsultation *getPaymentConsultation();

  void setPatient(Patient *patient);
  void setDate(string date);
  void setDescription(string description);
  void setPaymentConsultation(PaymentConsultation *paymentConsultation);
};

#endif /* CONSUTATION_H_ */