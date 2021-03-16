#include "../../domain/entities/schedule.hpp"

Schedule::Schedule() {}

Schedule::Schedule(string id, vector<Consultation> consultations)
{
    this->id = id;
    this->consultations = consultations;
}

Schedule::~Schedule() {}

string Schedule::getId()
{
    return this->id;
}

vector<Consultation> Schedule::getConsultations()
{
    return this->consultations;
}

void Schedule::setConsutations(vector<Consultation> consultations)
{
    this->consultations = consultations;
}

void Schedule::addConsultation(Consultation consultation){
    this->consultations.push_back(consultation);
}


void Schedule::print(){
    int i;
    cout<<"Id               |"
        <<"Patient          |"
        <<"Date             |"
        <<"Description      |"<<endl;

    vector<Consultation> consultations = getConsultations();
    for(i = 0; i < getConsultations().size(); i++){
        cout<<consultations[i].getId()<<"   |"
            <<consultations[i].getPatient().getName()<<"   |"
            <<consultations[i].getDate()<<"   |"
            <<consultations[i].getDescription()<<"   |"
            <<consultations[i].getPaymentConsultation().getValue()<<endl;
    }

}