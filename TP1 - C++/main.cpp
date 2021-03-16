#include <iostream>

#include "domain/entities/entities.hpp"

using namespace std;

int main()
{
  Admin admin("1");
  admin.setLogin("admin");
  admin.setPassword("admin");
  AdministrativeUser adminPermissions;
  admin.setPermissions(adminPermissions);

  Receptionist receptionist("2");
  receptionist.setLogin("ana");
  receptionist.setPassword("123");
  receptionist.setName("Ana Silva");
  GeneralUser receptionistPermissions;
  receptionist.setPermissions(receptionistPermissions);

  Clinic clinic("1", receptionist, admin);

  cout << clinic.getAdmin().getLogin() << endl;
  return 0;
}
