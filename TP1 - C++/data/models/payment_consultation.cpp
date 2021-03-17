#include "../../domain/entities/payment_consultation.hpp"

PaymentConsultation::PaymentConsultation(string id, double value, string patientName, string paymantDate):
    id(id),
    value(value),
    patientName(patientName),
    paymentDate(paymentDate){};
PaymentConsultation::~PaymentConsultation(){}

string PaymentConsultation::getId(){
    return this->id;
}
double PaymentConsultation::getValue(){
    return this->value;
}
void PaymentConsultation::setValue(double value){
    this->value = value;
}






