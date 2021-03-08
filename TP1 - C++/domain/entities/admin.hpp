#ifndef ADMIN_H_
#define ADMIN_H_

#include <string>
#include <iostream>

#include "user.hpp"

using namespace std;

class Admin : public User
{


public:
  Admin(string id);
  ~Admin();

  string getId();
};

#endif /* ADMIN_H_ */