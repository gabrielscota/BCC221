#ifndef TIMESHEET_H_
#define TIMESHEET_H_

#include <string>
#include <iostream>
#include <vector>

#include "point.hpp"

using namespace std;

class TimeSheet
{
  string id;
  vector<Point > points;

public:
  TimeSheet();
  TimeSheet(string id, vector<Point > points);
  ~TimeSheet();

  string getId();
  vector<Point > getPoints();
  Point getPoint(int index);

  void setPoints(vector<Point > points);
};

#endif /* TIMESHEET_H_ */