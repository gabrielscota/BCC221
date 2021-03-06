#include "../../domain/entities/patient.hpp"

Patient::Patient()
{
    Person();
}

Patient::Patient(string id) : Person(id)
{
}

Patient::Patient(string id, string name) : Person(id, name)
{
}

Patient::~Patient() {}

string Patient::getId()
{
    return Person::getId();
}
