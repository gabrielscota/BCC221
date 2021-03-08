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
  UserPermissions *permissions;

public:
  User(string id, string login, string password, UserPermissions *permissions);
  ~User();

  string getId();
  string getLogin();
  string getPassword();
  UserPermissions *getPermissions();

  void setLogin(string login);
  void setPassword(string password);
  void setPermissions(UserPermissions *permissions);
};

#endif /* USER_H_ */