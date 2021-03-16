#include "../../domain/entities/admin.hpp"

Admin::Admin(string id) : User(id){};
Admin::Admin() : User(){};

Admin::~Admin() {}

string Admin::getId()
{
  return User::getId();
}