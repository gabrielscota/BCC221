#ifndef USER_H_
#define USER_H_

#include <string>
#include <iostream>

#include "person.hpp"
#include "user_permissions.hpp"

using namespace std;

class User : public Person
{
  string login;
  string password;
  UserPermissions *userPermissions;

public:
  User();
  User(string id);
  User(string id, string login, string password, UserPermissions *userPermissions);
  ~User();

  string getId();
  string getLogin();
  string getPassword();
  UserPermissions *getUserPermissions();

  void setLogin(string login);
  void setPassword(string password);
  void setUserPermissions(UserPermissions *userPermissions);
};

#endif /* USER_H_ */