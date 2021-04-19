package presentation.controllers;

import data.usecases.authentication.LocalAuthentication;
import domain.entities.Clinic;
import domain.entities.Receptionist;
import domain.entities.UserPermissions;
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

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

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
  public boolean validateLogin() {
    if(loginTextField != null && loginTextField.getText().length() + 1 < 6){
      return false;
    }
    return true;
  }

  @Override
  public boolean validatePassword() {
    if(passwordTextField != null && passwordTextField.getText().length() + 1 < 6){
      return false;
    }
    return true;
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
    UUID clinicUUID = UUID.randomUUID();
    UUID receptionistUUID = UUID.randomUUID();
    List<String> permissions = Arrays.asList("SCHEDULE");
    UserPermissions userPermissions = new UserPermissions(receptionistUUID.toString(), permissions);
    Receptionist receptionist = new Receptionist(receptionistUUID.toString(), "Ana Silva", "ana", "123456", userPermissions);
    Clinic clinic = new Clinic(clinicUUID.toString(), receptionist, null);
    Stage homeStage = new Stage();
    this.homePage = new HomePage(new PresentationHomeController(clinic, homeStage));
    stage.close();
    homePage.build(homeStage);
  }
}
