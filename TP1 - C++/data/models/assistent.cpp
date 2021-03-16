#include "../../domain/entities/assistent.hpp"

Assistent::Assistent(){};

Assistent::Assistent(string id) : Employee(id){};

Assistent::~Assistent() {}

string Assistent::getId()
{
    return Employee::getId();
}