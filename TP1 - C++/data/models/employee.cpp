#include <vector>

#include "../../domain/entities/employee.hpp"

Employee::Employee(string id) : User(id)
{
    this->timeSheet = nullptr;
    this->payments;
}

Employee::Employee(string id, TimeSheet *timeSheet, vector<Payment *> payments) : User(id)
{
    this->timeSheet = timeSheet;
    this->payments = payments;
}

Employee::~Employee() {}

string Employee::getId()
{
    return User::getId();
}

TimeSheet *Employee::getTimeSheet()
{
    return this->timeSheet;
}

vector<Payment *> Employee::getPayments()
{
    return this->payments;
}

void Employee::setTimeSheet(TimeSheet *timeSheet)
{
    this->timeSheet = timeSheet;
}

void Employee::setPayments(vector<Payment *> payments)
{
    this->payments = payments;
}