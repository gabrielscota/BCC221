#include "../../domain/entities/consultation.hpp"

Consultation::Consultation(string id, Patient patient, string date, string description, PaymentConsultation paymentConsultation):
    id(id),
    patient(patient),
    date(date),
    description(description),
    paymentConsultation(paymentConsultation){};

Consultation::~Consultation(){};

string Consultation::getId(){
    return this->id;
}

Patient Consultation::getPatient(){
    return this->patient;
}

string Consultation::getDate(){
    return this->date;
}

string Consultation::getDescription(){
    return this->description;
}

PaymentConsultation Consultation::getPaymentConsultation(){
    return this->paymentConsultation;
}

void Consultation::setPatient(Patient patient){
    this->patient = patient;
}

void Consultation::setDate(string date){
    this->date = date;
}

void Consultation::setDescription(string description){
    this->description = description;
}

void Consultation::setPaymentConsultation(PaymentConsultation paymentConsultation){
    this->paymentConsultation = paymentConsultation;
}


