package presentation.controllers;

import data.usecases.authentication.LocalAuthentication;
import domain.usecases.authentication.AuthenticationParams;
import domain.usecases.authentication.UserAuthentication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import ui.pages.home.HomeController;
import ui.pages.login.LoginController;
import ui.pages.home.HomePage;
import ui.pages.home.HomeController;
import ui.pages.login.LoginPage;

public class PresentationLoginController implements LoginController {
  private final UserAuthentication userAuthentication;
  private final Stage stage;
  private String login;
  private String password;
  private HomePage homePage;
  @FXML
  TextField loginTextField = new TextField();
  @FXML
  TextField passwordTextField = new TextField();

  public PresentationLoginController(UserAuthentication userAuthentication, Stage stage) {
    this.userAuthentication = userAuthentication;
    this.stage = stage;
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
  public void auth() throws Exception {
    System.out.println("Login: " + loginTextField.getText());
    System.out.println("Senha: " + passwordTextField.getText());
    loadHomePage();
    userAuthentication.auth(new AuthenticationParams(login, password));
  }

  @Override
  public void loadHomePage() throws Exception{
    Stage homeStage = new Stage();
    this.homePage = new HomePage(new PresentationHomeController(null, homeStage));
    stage.close();
    homePage.build(homeStage);
  }
}
