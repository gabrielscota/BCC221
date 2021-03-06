#ifndef POINT_H_
#define POINT_H_

#include <string>
#include <iostream>

using namespace std;

class Point
{
  string id;
  string date;
  string observation;

public:
  Point(string id, string date, string observation);
  ~Point();

  string getId();
  string getDate();
  string getObservation();

  void setDate(string date);
  void setObservation(string observation);
};

#endif /* POINT_H_ */