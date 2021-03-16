#ifndef SCHEDULE_H_
#define SCHEDULE_H_

#include <string>
#include <iostream>
#include <vector>

#include "point.hpp"
#include "consultation.hpp"

using namespace std;

class Schedule
{
  string id;
  vector<Consultation> consultations;

public:
  Schedule();
  Schedule(string id, vector<Consultation> consultations);
  ~Schedule();

  string getId();
  vector<Consultation> getConsultations();

  void setConsutations(vector<Consultation> consultations);
  void addConsultation(Consultation consultation);
  void print();

};

#endif /* SCHEDULE_H_ */