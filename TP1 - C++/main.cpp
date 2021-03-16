#include <iostream>
#include <cstring>

#include "domain/entities/entities.hpp"

using namespace std;

void showMenuOptions(int typeUserPermissions)
{
  cout << "Selecione uma das opcoes a seguir:" << endl;

  switch (typeUserPermissions)
  {
  case 0:
    cout << "1 - Listar ortodontistas" << endl;
    cout << "0 - Sair" << endl;
    break;
  case 1:
    cout << "1 - Listar ortodontistas" << endl;
    cout << "2 - Cadastrar despesa" << endl;
    cout << "0 - Sair" << endl;
    break;
  case 2:
    cout << "1 - Listar ortodontistas" << endl;
    cout << "2 - Cadastrar despesa" << endl;
    cout << "3 - Relatorio" << endl;
    cout << "0 - Sair" << endl;
    break;
  }
}

void menu(Clinic clinic, User loggedUser)
{
  int typeUserPermissions = -1;
  if (typeid(loggedUser.getUserPermissions()) == typeid(GeneralUser))
  {
    typeUserPermissions = 0;
  }
  else if (typeid(loggedUser.getUserPermissions()) == typeid(AdministrativeAssistantUser))
  {
    typeUserPermissions = 1;
  }
  else if (typeid(loggedUser.getUserPermissions()) == typeid(AdministrativeUser))
  {
    typeUserPermissions = 2;
  }
  cout << typeUserPermissions << endl;

  if (typeUserPermissions != -1)
  {
    cout << "Bem vindo ao sistema de gerenciamento para clinicas." << endl;

    int option = -1;
    while (option != 0)
    {
      showMenuOptions(typeUserPermissions);

      cout << "> Informe uma das opcoes acima: " << endl;
      switch (option)
      {
      case 1:
        clinic.listOrthodontists();
        break;
      }
    }
  }
}

User login(Clinic clinic)
{
  int option = 1;
  cout << "Bem vindo ao sistema de gerenciamento para clinicas." << endl;

  string login;
  string password;

  User loggedUser;

  while (option)
  {
    cout << "> Informe seu login: " << endl;
    cin >> login;
    cout << "> Informe sua senha: " << endl;
    cin >> password;

    if (clinic.getAdmin().getLogin().compare(login) == 0 && clinic.getAdmin().getPassword().compare(password) == 0)
    {
      loggedUser = clinic.getAdmin();
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
      cout << "[!] Usuario ou senha invalidos, tente novamente." << endl;
    }
  }
  return User();
}

int main()
{
  GeneralUser *receptionistPermissions;
  AdministrativeAssistantUser *assistentPermissions;
  AdministrativeUser *adminPermissions;

  Admin admin("1");
  admin.setLogin("admin");
  admin.setPassword("admin");
  admin.setUserPermissions(adminPermissions);

  Receptionist receptionist("2");
  receptionist.setLogin("ana");
  receptionist.setPassword("123");
  receptionist.setName("Ana Silva");
  receptionist.setUserPermissions(receptionistPermissions);

  Clinic clinic("1", receptionist, admin);
  clinic.setAdmin(admin);
  clinic.setReceptionist(receptionist);

  Assistent assistent("3");
  assistent.setLogin("joao");
  assistent.setPassword("123");
  assistent.setName("Joao");
  assistent.setUserPermissions(assistentPermissions);

  vector<Assistent> assistents = clinic.getAssistents();
  assistents.push_back(assistent);
  clinic.setAssistents(assistents);

  User loggedUser = login(clinic);
  if (!loggedUser.getLogin().compare(" ") == 0)
  {
    system("clear || cls");
    cout << typeid(loggedUser.getUserPermissions()).name() << endl;
    menu(clinic, loggedUser);
  }
  return 0;
}
