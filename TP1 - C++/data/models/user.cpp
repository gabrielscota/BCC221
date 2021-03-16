#include "../../domain/entities/user.hpp"

User::User() : Person()
{
    login = ' ';
    password = ' ';
}

User::User(string id) : Person(id)
{
    login = ' ';
    password = ' ';
}

User::User(string id, string login, string password, UserPermissions *userPermissions) : Person(id)
{
    this->login = login;
    this->password = password;
    this->userPermissions = userPermissions;
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

void User::setUserPermissions(UserPermissions *userPermissions)
{
    this->userPermissions = userPermissions;
}

string User::getLogin()
{
    return this->login;
}
string User::getPassword()
{
    return this->password;
}
UserPermissions *User::getUserPermissions()
{
    return this->userPermissions;
}
string User::getId()
{
    return Person::getId();
}
/*void setLogin(string login);
  void setPassword(string password);
  void setPermissions(UserPermissions *permissions);*/