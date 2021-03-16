#include "../../domain/entities/user.hpp"

User::User() : Person()
{
    login = ' ';
    password = ' ';
    permissions = UserPermissions();
}

User::User(string id) : Person(id)
{
    login = ' ';
    password = ' ';
    permissions = UserPermissions();
}

User::User(string id, string login, string password, UserPermissions permissions) : Person(id)
{
    this->login = login;
    this->password = password;
    this->permissions = permissions;
}

User::~User() {}

void User::setLogin(string login)
{
    this->login = login;
}

void User::setPassword(string password)
{
    this->password = password;
}

void User::setPermissions(UserPermissions permissions)
{
    this->permissions = permissions;
}

string User::getLogin(){
    return this->login;
}
string User::getPassword(){
    return this->password;
}
UserPermissions User::getPermissions(){
    return this->permissions;
}
string User::getId(){
    return Person::getId();
}
/*void setLogin(string login);
  void setPassword(string password);
  void setPermissions(UserPermissions *permissions);*/