#include "../../domain/entities/clinic.hpp"

Clinic::Clinic(string id, vector<Orthodontist> orthodontists, vector<Assistent> assistents,
               vector<Patient> patients, vector<Expense> expenses, Receptionist receptionist, Admin admin)
{
    this->id = id;
    this->orthodontists = orthodontists;
    this->assistents = assistents;
    this->expenses = expenses;
    this->receptionist = receptionist;
    this->admin = admin;
};

Clinic::Clinic(string id, Receptionist receptionist, Admin admin)
{
    this->id = id;
    this->receptionist = receptionist;
    this->admin = admin;
};

Clinic::~Clinic(){};

string Clinic::getId()
{
    return this->id;
}

vector<Orthodontist> Clinic::getOrthodontists()
{
    return this->orthodontists;
}

Orthodontist Clinic::getOrthodontist(int index)
{
    return this->orthodontists[index];
}

vector<Assistent> Clinic::getAssistents()
{
    return this->assistents;
}

vector<Patient> Clinic::getPatients()
{
    return this->patients;
}

vector<Expense> Clinic::getExpenses()
{
    return this->expenses;
}

Receptionist Clinic::getReceptionist()
{
    return this->receptionist;
}

Admin Clinic::getAdmin()
{
    return this->admin;
}

User Clinic::getLoggedUser()
{
    return this->loggedUser;
}

void Clinic::setOrthodontists(vector<Orthodontist> orthodontists)
{
    this->orthodontists = orthodontists;
}

void Clinic::setOrthodontist(Orthodontist orthodontist, int index)
{
    this->orthodontists[index] = orthodontist;
}

void Clinic::setAssistents(vector<Assistent> assistents)
{
    this->assistents = assistents;
}

void Clinic::setPatients(vector<Patient> patients)
{
    this->patients = patients;
}

void Clinic::setExpenses(vector<Expense> expenses)
{
    this->expenses = expenses;
}

void Clinic::setReceptionist(Receptionist receptionist)
{
    this->receptionist = receptionist;
}

void Clinic::setAdmin(Admin admin)
{
    this->admin = admin;
}

void Clinic::addConsultation(Consultation consultation, int index)
{
    Orthodontist aux = getOrthodontist(index);
    aux.addConsultation(consultation);
    this->setOrthodontist(aux, index);
}

void Clinic::listOrthodontists()
{
    for (int i = 0; i < this->orthodontists.size(); i++)
    {
        cout << i << " - " << this->orthodontists[i].getName() << endl;
    }
}

void Clinic::displaySchedule(int index)
{
    Orthodontist orthodontist = getOrthodontist(index);
    orthodontist.printSchedule();
}

void Clinic::setLoggedUser(User loggedUser)
{
    this->loggedUser = loggedUser;
}

void Clinic::clinicMenu()
{
    system("clear || cls");
    cout << "\n--- Bem vindo, " << this->loggedUser.getName() << "! ---\n"
         << endl;
    this->loggedUser.getUserPermissions()->showMenuOptions(this);
   
}

void Clinic::payExpense(){
    string description, dueDate, paymentDate, expenseType;
    float value;
    cout << "Insira o tipo da despesa: " << endl;
    cin >> expenseType;
    cout << "Insira o valor da despesa: " << endl;
    cin >> value;
    cout << "Insira a data de vencimento da despesa: " << endl;
    cin >> dueDate;
    cout << "Insira a data de pagamento da empresa: " << endl;
    cin >> paymentDate;
    cout << "Insira a descricao da despesa: " << endl;
    cin >> description;

    string id = to_string(this->expenses.size() + 1);
    Expense expense(id, description, dueDate, paymentDate, expenseType, value); 
    this->expenses.push_back(expense);
}
