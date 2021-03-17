#include <vector>

#include "../../domain/entities/employee.hpp"

Employee::Employee() {}

Employee::Employee(string id) : User(id)
{
    this->payments;
}

Employee::Employee(string id, TimeSheet timeSheet, vector<Payment *> payments) : User(id)
{
    this->timeSheet = timeSheet;
    this->payments = payments;
}

Employee::~Employee() {}

string Employee::getId()
{
    return User::getId();
}

TimeSheet Employee::getTimeSheet()
{
    return this->timeSheet;
}

vector<Payment *> Employee::getPayments()
{
    return this->payments;
}

void Employee::setTimeSheet(TimeSheet timeSheet)
{
    this->timeSheet = timeSheet;
}

void Employee::setPayments(vector<Payment *> payments)
{
    this->payments = payments;
}

void Employee::printTimeSheet(){
    cout<<"\t FOLHA DE PONTO - "<<getName()<<endl
        <<"Data\t\t\t| Observacao"<<endl;

    for(int i = 0; i < getTimeSheet().getPoints().size(); i++){
        cout<<getTimeSheet().getPoint(i).getDate()<<"\t     |"<<getTimeSheet().getPoint(i).getObservation()<<endl;
    }
}

