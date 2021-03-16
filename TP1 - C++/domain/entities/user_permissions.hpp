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
  virtual string getType();
  virtual void showMenuOptions();
  void setPermissions(vector<string> permissions);
};

class GeneralUser : public UserPermissions
{
public:
  GeneralUser();
  ~GeneralUser();
  virtual string getType();
  virtual void showMenuOptions();
};

class AdministrativeAssistantUser : public UserPermissions
{
public:
  AdministrativeAssistantUser();
  ~AdministrativeAssistantUser();
  virtual string getType();
  virtual void showMenuOptions();
};

class AdministrativeUser : public UserPermissions
{
public:
  AdministrativeUser();
  ~AdministrativeUser();
  virtual string getType();
  virtual void showMenuOptions();
};

#endif /* USERPERMISSIONS_H_ */