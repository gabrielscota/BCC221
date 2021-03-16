#include "../../domain/entities/user_permissions.hpp"

UserPermissions::UserPermissions(){}

UserPermissions::UserPermissions(string id, vector<string> permissions){
    this->id = id;
    this->permissions = permissions;
}

UserPermissions::~UserPermissions(){}

string UserPermissions::getId(){
    return this->id;
}

vector<string> UserPermissions::getPermissions(){
    return this->permissions;
}

void UserPermissions::setPermissions(vector <string> permissions){
    this->permissions = permissions;
}

//  GeneralUser, AdministrativeAssistantUser, AdministrativeUser left

GeneralUser::GeneralUser(){};
GeneralUser::~GeneralUser(){};

AdministrativeAssistantUser::AdministrativeAssistantUser(){};
AdministrativeAssistantUser::~AdministrativeAssistantUser(){};

AdministrativeUser::AdministrativeUser(){};
AdministrativeUser::~AdministrativeUser(){};