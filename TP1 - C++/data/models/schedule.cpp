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