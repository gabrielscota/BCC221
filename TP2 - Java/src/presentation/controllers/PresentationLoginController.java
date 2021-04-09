package presentation.controllers;

import domain.usecases.authentication.AuthenticationParams;
import domain.usecases.authentication.UserAuthentication;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import ui.pages.login.LoginController;

public class PresentationLoginController implements LoginController {
  private final UserAuthentication userAuthentication;

  private String login;
  private String password;

  @FXML
  TextField loginTextField = new TextField();
  @FXML
  TextField passwordTextField = new TextField();

  public PresentationLoginController(UserAuthentication userAuthentication) {
    this.userAuthentication = userAuthentication;
  }

  @Override
  public void validateLogin() {
    if(loginTextField != null && loginTextField.getText().length() + 1 < 6){
      System.out.println("Login invalido!");
    } else {
      System.out.println("Login: " + loginTextField.getText().substring(0, loginTextField.getText().length()));
      login = loginTextField.getText();
    }
  }

  @Override
  public void validatePassword() {
    if(passwordTextField != null && passwordTextField.getText().length() + 1 < 6){
      System.out.println("Password invalido!");
    } else {
      System.out.println("Password: " + passwordTextField.getText().substring(0, passwordTextField.getText().length()));
      password = passwordTextField.getText();
    }
  }

  @Override
  public void auth() {
    System.out.println("Login: " + loginTextField.getText());
    System.out.println("Senha: " + passwordTextField.getText());
    userAuthentication.auth(new AuthenticationParams(login, password));
  }
}
