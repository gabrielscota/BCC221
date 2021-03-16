#include "../../domain/entities/payment_consultation.hpp"

PaymentConsultation::PaymentConsultation(string id, double value):
    id(id),
    value(value){};

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






