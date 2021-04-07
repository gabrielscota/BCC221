package domain.usecases.authentication;

public class AuthenticationParams {
  private final String login;
  private final String password;

  public AuthenticationParams(String login, String password) {
    this.login = login;
    this.password = password;
  }

  public String getLogin() {
    return login;
  }

  public String getPassword() {
    return password;
  }
}
