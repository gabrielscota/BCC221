#include "../../domain/entities/orthodontist.hpp"

Orthodontist::Orthodontist(string id):
   Employee(id){};

Orthodontist::~Orthodontist(){};

string Orthodontist::getId(){
    return this->id;
} 

Schedule Orthodontist::getSchedule(){
    return this->schedule;
} 

Assistent Orthodontist::getAssistent(){
    return this->assistent;
}

void Orthodontist::setSchedule(Schedule schedule){
    this->schedule = schedule;
}

void Orthodontist::setAssistent(Assistent assistent){
    this->assistent = assistent;
}

void Orthodontist::printSchedule(){
    this->schedule.print();
}

void Orthodontist::addConsultation(Consultation consultation){
    this->schedule.addConsultation(consultation);
}