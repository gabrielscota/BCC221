#ifndef ADMIN_H_
#define ADMIN_H_

#include <string>
#include <iostream>

#include "user.hpp"

using namespace std;

class Admin : virtual public User
{
  string id;

public:
  Admin();
  Admin(string id);
  ~Admin();

  string getId();
};

#endif /* ADMIN_H_ */