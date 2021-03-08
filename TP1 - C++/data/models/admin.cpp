#include "admin.hpp"

Admin::Admin(string id){
    Person(id);
    User();
}

Admin::~Admin(){}

string Admin::getId(){
    return User::getId();
}