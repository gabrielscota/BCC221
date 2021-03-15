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
  UserPermissions(string id, vector<string> permissions);
  ~UserPermissions();

  string getId();
  vector<string> getPermissions();

  void setPermissions(vector<string> permissions);
};

class GeneralUser : public UserPermissions
{
};

class AdministrativeAssistantUser : public UserPermissions
{
  
};

class AdministrativeUser : public UserPermissions
{

};

#endif /* USERPERMISSIONS_H_ */