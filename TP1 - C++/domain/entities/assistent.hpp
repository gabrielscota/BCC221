#ifndef ASSISTENT_H_
#define ASSISTENT_H_

#include <string>
#include <iostream>

#include "employee.hpp"

using namespace std;

class Assistent : public Employee
{
  string id;

public:
  Assistent(string id);
  ~Assistent();

  string getId();
};

#endif /* ASSISTENT_H_ */