#include "../../domain/entities/receptionist.hpp"

Receptionist::Receptionist(string id):
    Employee(id){};

Receptionist::~Receptionist(){}

string Receptionist::getId(){
    return Employee::getId();
}