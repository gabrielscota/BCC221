#include "assistent.hpp"

Assistent::Assistent(string id):
    Employee(id){};

Assistent::~Assistent(){}

string Assistent::getId(){
     return Employee::getId();
}