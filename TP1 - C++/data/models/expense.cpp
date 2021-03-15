#include "expense.hpp"

Expense::Expense(string id, string getDescription, string dueDate, string paymentDate, string expenseType):
    id(id),
    description(description),
    dueDate(dueDate),
    paymentDate(paymentDate),
    expenseType(expenseType){};

Expense::~Expense(){};

string Expense::getId(){
    return this->id;
}

string Expense::getDescription(){
    return this->description;
}

string Expense::getDueDate(){
    return this->dueDate;
}

string Expense::getPaymentDate(){
    return this->paymentDate;
}

string Expense::getExpenseType(){
    return this->expenseType;
}

void Expense::setDescription(string description){
    this->description = description;
}

void Expense::setDueDate(string dueDate){
    this->dueDate = dueDate;
}

void Expense::setPaymentDate(string paymentDate){
    this->paymentDate = paymentDate;
}

void Expense::setExpenseType(string expenseType){
    this->expenseType = expenseType;
}