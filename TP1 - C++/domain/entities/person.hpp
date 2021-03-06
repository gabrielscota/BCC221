#ifndef PERSON_H_
#define PERSON_H_

#include <string>
#include <iostream>

using namespace std;

class Person
{
  string id;
  string name;

public:
  Person(string id, string name);
  Person(string id);            //Constructor method with null name
  Person();                     //Empty constructor method
  ~Person();

  string getId();
  string getName();

  void setName(string name);
};

#endif /* PERSON_H_ */