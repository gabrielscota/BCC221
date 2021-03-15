#include "payment.hpp"

Payment::Payment(string id, string date, double value, string description):
    id(id),
    date(date),
    value(value),
    description(description){};

Payment::~Payment(){};

string Payment::getId(){
    return this->id;
}

string Payment::getDate(){
    return this->date;
}

double Payment::getValue(){
    return this->value;
}

string Payment::getDescription(){
    return this->description;
}

void Payment::setDate(string date){
    this->date = date;
}

void Payment::setValue(double value){
    this->value = value;
}

void Payment::setDescription(string description){
    this->description = description;
}