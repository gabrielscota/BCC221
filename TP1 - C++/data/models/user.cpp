#include "user.hpp"

User::User(){
    Person();
    login = ' ';
    password = ' ';
    permissions = nullptr;
}

User::User(string id){
    Person(id);
    login = ' ';
    password = ' ';
    permissions = nullptr;
}

User::User(string id, string login, string password, UserPermissions *permissions){
    Person(id);
    this->login = login;
    this->password = password;
    this->permissions = permissions;
}

User::~User(){}

void User::setLogin(string login){
    this->login = login;
}

void User::setPassword(string password){
    this->password = password;
}


void User::setPermissions(UserPermissions *permissions){
    this->permissions = permissions;
}

/*void setLogin(string login);
  void setPassword(string password);
  void setPermissions(UserPermissions *permissions);*/