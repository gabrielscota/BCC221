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


void Clinic::setOrthodontist(Orthodontist orthodontist, int index)
{
    this->orthodontists[index] = orthodontist;
}
void Clinic::setOrthodontists(vector<Orthodontist> orthodontists)
{
    this->orthodontists= orthodontists;
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

void Clinic::listAssistents()
{
    for (int i = 0; i < this->assistents.size(); i++)
    {
        cout << i << " - " << this->assistents[i].getName() << endl;
    }
}

void Clinic::printReceptionist(){
    cout <<this->receptionist.getName()<< endl;
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

void Clinic::createConsultation(int indexOrtho)
{
  string patientName, date, description, buffer;
  Orthodontist orthodontist = getOrthodontist(indexOrtho);
  Schedule schedule = orthodontist.getSchedule();
  vector <Consultation> consultations = schedule.getConsultations();
  getline(cin, buffer);
  double value;
  cout << "\n[!]Digite o nome do paciente: ";
  getline(cin, patientName);
  Patient patient("10", patientName);
  cout << "\n[!]Digite a data da consulta: ";
  getline(cin, date);
  cout << "\n[!]Digite a descricao da consulta: ";
  getline(cin, description);
  cout << "\n[!]Digite o valor da consulta: ";
  cin >> value;
  PaymentConsultation payment("10", value);
  Consultation consultation("10", patient, date, description, payment);
  consultations.push_back(consultation);
  schedule.setConsultations(consultations);
  orthodontist.setSchedule(schedule);
  setOrthodontist(orthodontist, indexOrtho);
}

void Clinic::editarConsulta(int indexOrtho, int index){
  string id, patientName, date, description, buffer;
  Orthodontist orthodontist = getOrthodontist(indexOrtho);
  Schedule schedule = orthodontist.getSchedule();
  id = orthodontist.getSchedule().getConsultation(index).getId();
  Patient patient = orthodontist.getSchedule().getConsultation(index).getPatient();
  PaymentConsultation payment = orthodontist.getSchedule().getConsultation(index).getPaymentConsultation();
  date = orthodontist.getSchedule().getConsultation(index).getDate();
  description = orthodontist.getSchedule().getConsultation(index).getDescription();

  int check;
  double value;
  
  patientName = patient.getName();
  value = payment.getValue();

  getline(cin, buffer);
  cout <<"\n[!]Deseja alterar o nome do paciente?"<<endl;
  cout <<"[1] SIM"<<endl;
  cout <<"[2] NAO\n"<<endl;
  cin  >> check;
  
  getline(cin, buffer);
  if(check == 1){
    cout<<"\n[!]Digite o nome do paciente: ";
    getline(cin, patientName);
    patient.setName(patientName);
  }
  

  cout <<"\n[!]Deseja alterar a data da consulta?"<<endl;
  cout <<"[1] SIM"<<endl;
  cout <<"[2] NAO\n"<<endl;
  cin  >> check;
  
  getline(cin, buffer);
  if(check == 1){
    cout<<"\n[!]Digite a data da consulta: ";
    getline(cin, date);
  }
  
  cout <<"\n[!]Deseja alterar a descricao da consulta?"<<endl;
  cout <<"[1] SIM"<<endl;
  cout <<"[2] NAO\n"<<endl;
  cin  >> check;
  
  getline(cin, buffer);
  if(check == 1){
    cout<<"\n[!]Digite a descricao da consulta: ";
    getline(cin, description);
  }
  
  cout <<"\n[!]Deseja alterar o valor da consulta?"<<endl;
  cout <<"[1] SIM"<<endl;
  cout <<"[2] NAO\n"<<endl;
  cin  >> check;
  
  getline(cin, buffer);
  if(check == 1){
    cout<<"\n[!]Digite o valor da consulta: ";
    cin>>value;
    payment.setValue(value);
  }
  
  Consultation consultation(id, patient, date, description, payment);
  schedule.setConsultation(consultation, index);
  orthodontist.setSchedule(schedule);
  setOrthodontist(orthodontist, indexOrtho);
}

void Clinic::deleteConsulta(int indexOrtho, int index){
  Orthodontist orthodontist = getOrthodontist(indexOrtho);
  Schedule schedule = orthodontist.getSchedule();
  vector<Consultation> consultations = orthodontist.getSchedule().getConsultations();
  
  consultations.erase(consultations.begin() + index);

  //erase(consultations, index);
  schedule.setConsultations(consultations);
  orthodontist.setSchedule(schedule);
  setOrthodontist(orthodontist, indexOrtho);

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

vector<PaymentConsultation> Clinic::getPayments(){
     return this->payments;
}

void Clinic::receiveConsultation(){
    this->listOrthodontists();
    int orthodontistIndex;
    cout << "Digite o numero do ortodontista da consulta que deseja receber pagamento" << endl;
    cin >> orthodontistIndex;
    Orthodontist orthodontist = this->getOrthodontist(orthodontistIndex-1);
    vector<Consultation> orthodontistSchedule = orthodontist.getSchedule().getConsultations();
}