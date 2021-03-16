#include <iostream>
#include <cstring>

#include "domain/entities/entities.hpp"

using namespace std;

Consultation createConsultation();

User login(Clinic clinic)
{
  int option = 1;
  cout << "\n--- Bem vindo ao sistema de gerenciamento para clinicas. ---\n"
       << endl;

  string login;
  string password;

  User loggedUser;

  while (option)
  {
    cout << "> Informe seu login: ";
    cin >> login;
    cout << "> Informe sua senha: ";
    cin >> password;

    if (clinic.getAdmin().getLogin().compare(login) == 0 && clinic.getAdmin().getPassword().compare(password) == 0)
    {
      loggedUser = clinic.getAdmin();
      cout << "Foi" << endl;
      return loggedUser;
    }
    else if (clinic.getReceptionist().getLogin().compare(login) == 0 && clinic.getReceptionist().getPassword().compare(password) == 0)
    {
      loggedUser = clinic.getReceptionist();
      return loggedUser;
    }
    else
    {
      vector<Assistent> assistents = clinic.getAssistents();
      for (int i = 0; i < assistents.size(); i++)
      {
        if (assistents[i].getLogin().compare(login) == 0 && assistents[i].getPassword().compare(password) == 0)
        {
          loggedUser = assistents[i];
          return loggedUser;
        }
      }
    }

    if (login.compare("sair") == 0)
    {
      option = 0;
    }
    else
    {
      cout << "\n[!] Usuario ou senha invalidos, tente novamente.\n"
           << endl;
    }
  }
  return User();
}

Consultation createConsultation()
{
  string patientName, date, description, buffer;
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
  return consultation;
}

int main()
{
  system("clear || cls");

  GeneralUser receptionistPermissions;
  AdministrativeAssistantUser assistentPermissions;
  AdministrativeUser adminPermissions;

  Admin admin("1");
  admin.setLogin("admin");
  admin.setPassword("admin");
  admin.setName("Administrador");
  admin.setUserPermissions(&adminPermissions);

  Receptionist receptionist("2");
  receptionist.setLogin("ana");
  receptionist.setPassword("123");
  receptionist.setName("Ana Silva");
  receptionist.setUserPermissions(&receptionistPermissions);

  Clinic clinic("1", receptionist, admin);
  clinic.setAdmin(admin);
  clinic.setReceptionist(receptionist);

  Assistent assistent("3");
  assistent.setLogin("joao");
  assistent.setPassword("123");
  assistent.setName("Joao Silva");
  assistent.setUserPermissions(&assistentPermissions);

  vector<Assistent> assistents = clinic.getAssistents();
  assistents.push_back(assistent);
  clinic.setAssistents(assistents);

  Orthodontist orthodontist("4");
  orthodontist.setLogin("cleiton");
  orthodontist.setPassword("123");
  orthodontist.setName("Cleiton Rasta");
  orthodontist.setAssistent(assistent);

  Orthodontist orthodontist2("5");
  orthodontist2.setLogin("cleitin");
  orthodontist2.setPassword("123");
  orthodontist2.setName("Cleiton Filho do Rasta");
  orthodontist2.setAssistent(assistent);

  vector<Orthodontist> orthodontists = clinic.getOrthodontists();
  orthodontists.push_back(orthodontist);
  orthodontists.push_back(orthodontist2);
  clinic.setOrthodontists(orthodontists);
  clinic.setLoggedUser(login(clinic));

  if (!clinic.getLoggedUser().getLogin().compare(" ") == 0)
  {
    system("clear || cls");
    clinic.clinicMenu();
  }
  return 0;
}
