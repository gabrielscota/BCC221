#include "../../domain/entities/clinic.hpp"


Clinic::Clinic(string id, vector<Orthodontist *> orthodontists, vector<Assistent *> assistents, 
vector<Patient *> patients, vector<Expense *> expenses, Receptionist *receptionist, Admin *admin):
id(id),
orthodontists(orthodontists),
assistents(assistents),
expenses(expenses),
receptionist(receptionist),
admin(admin)
{};

Clinic::~Clinic(){};

string Clinic::getId(){
    return this->id;
}

vector<Orthodontist *> Clinic::getOrthodontists(){
    return this->orthodontists;
}

vector<Assistent *> Clinic::getAssistents(){
    return this->assistents;
}

vector<Patient *> Clinic::getPatients(){
    return this->patients;
}

vector<Expense *> Clinic::getExpenses(){
    return this->expenses;
}

Receptionist * Clinic::getReceptionist(){
    return this->receptionist;
}

Admin* Clinic::getAdmin(){
    return this->admin;
}

void Clinic::setOrthodontists(vector<Orthodontist *> orthodontists){
    this->orthodontists = orthodontists;
}

void Clinic::setAssistents(vector<Assistent *> assistents){
    this->assistents = assistents;
}

void Clinic::setPatients(vector<Patient *> patients){
    this->patients = patients;
}

void Clinic::setExpenses(vector<Expense *> expenses){
    this->expenses = expenses;
}

void Clinic::setReceptionist(Receptionist*  receptionist){
    this->receptionist = receptionist;
}

void Clinic::setAdmin(Admin*  admin){
    this->admin = admin;
}

void Clinic::listOrthodontists(){
    for (int i = 0; i < this->orthodontists.size(); i++)
    {
        cout << this->orthodontists[i] << endl;
    }
    
}