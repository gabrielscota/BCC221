#ifndef SCHEDULE_H_
#define SCHEDULE_H_

#include <string>
#include <iostream>
#include <vector>

#include "point.hpp"
#include "consutation.hpp"

using namespace std;

class Schedule
{
  string id;
  vector<Consutation *> consutations;

public:
  Schedule(string id, vector<Consutation *> consutations);
  ~Schedule();

  string getId();
  vector<Consutation *> getConsutations();

  void setConsutations(vector<Consutation *> consutations);
};

#endif /* SCHEDULE_H_ */