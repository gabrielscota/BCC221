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

AdministrativeAssistantUser::AdministrativeAssistantUser()
{
    this->setPermissions({"schedule"});
};

AdministrativeAssistantUser::~AdministrativeAssistantUser(){};

string AdministrativeAssistantUser::getType()
{
    return "AdministrativeAssistantUser";
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
