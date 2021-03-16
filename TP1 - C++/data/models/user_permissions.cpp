#include "../../domain/entities/user_permissions.hpp"

UserPermissions::UserPermissions() {}

UserPermissions::UserPermissions(string id, vector<string> permissions)
{
    this->id = id;
    this->permissions = permissions;
}

UserPermissions::~UserPermissions() {}

string UserPermissions::getId()
{
    return this->id;
}

void UserPermissions::showMenuOptions(){
    cout << "" << endl;
}

vector<string> UserPermissions::getPermissions()
{
    return this->permissions;
}

string UserPermissions::getType(){
    return "UserPermissions";
}

void UserPermissions::setPermissions(vector<string> permissions)
{
    this->permissions = permissions;
}

//  GeneralUser, AdministrativeAssistantUser, AdministrativeUser left

GeneralUser::GeneralUser()
{
    this->setPermissions({"schedule"});
};

GeneralUser::~GeneralUser(){};

string GeneralUser::getType()
{
    return "GeneralUser";
}

void GeneralUser::showMenuOptions(){
        cout << "1 - Agenda" << endl;
        cout << "0 - Sair" << endl;
}

AdministrativeAssistantUser::AdministrativeAssistantUser()
{
    this->setPermissions({"schedule"});
};

AdministrativeAssistantUser::~AdministrativeAssistantUser(){};

string AdministrativeAssistantUser::getType()
{
    return "AdministrativeAssistantUser";
}

void AdministrativeAssistantUser::showMenuOptions(){
    cout << "1 - Agenda" << endl;
    cout << "2 - Cadastrar despesa" << endl;
    cout << "0 - Sair" << endl;
}

AdministrativeUser::AdministrativeUser()
{
    this->setPermissions({"schedule"});
};

AdministrativeUser::~AdministrativeUser(){};

string AdministrativeUser::getType()
{
    return "AdministrativeUser";
}

void AdministrativeUser::showMenuOptions(){
    cout << "1 - Agenda" << endl;
    cout << "2 - Cadastrar despesa" << endl;
    cout << "3 - Relatorio" << endl;
    cout << "0 - Sair" << endl;
}