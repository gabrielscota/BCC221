package data.usecases.authentication;

import domain.usecases.authentication.AuthenticationParams;
import domain.usecases.authentication.UserAuthentication;

public class LocalAuthentication implements UserAuthentication {
  @Override
  public String auth(AuthenticationParams params) {
    return params.getLogin().equals("admin") && params.getPassword().equals("123456") ? "Admin" : null;
  }
}
