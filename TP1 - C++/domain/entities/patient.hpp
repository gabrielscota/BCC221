#ifndef PATIENT_H_
#define PATIENT_H_

#include <string>
#include <iostream>

#include "person.hpp"

using namespace std;

class Patient : public Person
{
  

public:
  Patient();
  Patient(string id, string name);
  ~Patient();

  string getId();
};

#endif /* PATIENT_H_ */