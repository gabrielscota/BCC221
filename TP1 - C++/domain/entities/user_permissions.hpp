#ifndef USERPERMISSIONS_H_
#define USERPERMISSIONS_H_

#include <string>
#include <iostream>
#include <vector>

using namespace std;

class UserPermissions
{
  string id;
  vector<string> permissions;

public:
  UserPermissions();
  UserPermissions(string id, vector<string> permissions);
  ~UserPermissions();

  string getId();
  vector<string> getPermissions();

  void setPermissions(vector<string> permissions);
};

class GeneralUser : public UserPermissions
{
public:
  GeneralUser();
  ~GeneralUser();
};

class AdministrativeAssistantUser : public UserPermissions
{
public:
  AdministrativeAssistantUser();
  ~AdministrativeAssistantUser();
};

class AdministrativeUser : public UserPermissions
{
public:
  AdministrativeUser();
  ~AdministrativeUser();
};

#endif /* USERPERMISSIONS_H_ */