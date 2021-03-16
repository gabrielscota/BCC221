#include <iostream>

#include "domain/entities/admin.hpp"

using namespace std;

int main()
{
  Admin admin("teste");
  admin.setLogin("admin");
  admin.setPassword("admin");

  cout << admin.getLogin() << endl;
  return 0;
}
