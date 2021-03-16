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

class GeneralUser : virtual public UserPermissions
{
};

class AdministrativeAssistantUser : virtual public UserPermissions
{
  
};

class AdministrativeUser : virtual public UserPermissions
{

};

#endif /* USERPERMISSIONS_H_ */