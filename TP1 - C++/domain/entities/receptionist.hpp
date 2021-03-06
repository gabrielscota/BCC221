#ifndef RECEPTIONIST_H_
#define RECEPTIONIST_H_

#include <string>
#include <iostream>

#include "employee.hpp"

using namespace std;

class Receptionist : public Employee
{
  string id;

public:
  Receptionist(string id);
  ~Receptionist();

  string getId();
};

#endif /* RECEPTIONIST_H_ */