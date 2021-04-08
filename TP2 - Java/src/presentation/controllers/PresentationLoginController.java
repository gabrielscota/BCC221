package presentation.controllers;

import domain.usecases.authentication.AuthenticationParams;
import domain.usecases.authentication.UserAuthentication;
import javafx.fxml.FXML;
import ui.pages.login.LoginController;

public class PresentationLoginController implements LoginController {
  private final UserAuthentication userAuthentication;

  private String login;
  private String password;

  public PresentationLoginController(UserAuthentication userAuthentication) {
    this.userAuthentication = userAuthentication;
  }

  @Override
  public void validatePassword(String password) {

  }

  @Override
  public void auth() {
    userAuthentication.auth(new AuthenticationParams(getLogin(), getPassword()));
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void printTest() {
    System.out.println("Teste");
  }
}
