#ifndef USERPERMISSIONS_H_
#define USERPERMISSIONS_H_

#include <string>
#include <iostream>
#include <vector>
using namespace std;

class Clinic;
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
  virtual void showMenuOptions(Clinic *clinic);
  void setPermissions(vector<string> permissions);
};

class GeneralUser : public UserPermissions
{
public:
  GeneralUser();
  ~GeneralUser();
  virtual string getType();
  virtual void showMenuOptions(Clinic *clinic);
};

class AdministrativeAssistantUser : public UserPermissions
{
public:
  AdministrativeAssistantUser();
  ~AdministrativeAssistantUser();
  virtual string getType();
  virtual void showMenuOptions(Clinic *clinic);
};

class AdministrativeUser : public UserPermissions
{
public:
  AdministrativeUser();
  ~AdministrativeUser();
  virtual string getType();
  virtual void showMenuOptions(Clinic *clinic);
};

void scheduleOption(Clinic *clinic);

#endif /* USERPERMISSIONS_H_ */

