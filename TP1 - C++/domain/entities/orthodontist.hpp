#ifndef ORTHODONTIST_H_
#define ORTHODONTIST_H_

#include <string>
#include <iostream>

#include "employee.hpp"
#include "schedule.hpp"
#include "assistent.hpp"

using namespace std;

class Orthodontist : public Employee
{
  string id;
  Schedule schedule;
  Assistent assistent;

public:
  
  Orthodontist(string id);
  ~Orthodontist();

  string getId();
  Schedule getSchedule();
  Assistent getAssistent();

  void setSchedule(Schedule schedule);
  void setAssistent(Assistent assistent);
  void printSchedule();
  void addConsultation(Consultation consultation);
  void editSchedule(int index);
};

#endif /* ORTHODONTIST_H_ */