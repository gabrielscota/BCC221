package presentation.controllers;

import data.usecases.authentication.LocalAuthentication;
import domain.entities.*;
import domain.usecases.authentication.AuthenticationParams;
import domain.usecases.authentication.UserAuthentication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
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
  @FXML
  Button loginButton = new Button();

  public PresentationLoginController(UserAuthentication userAuthentication, Stage stage) {
    this.userAuthentication = userAuthentication;
    this.stage = stage;
  }

  @Override
  public void validateLogin() {
    login = loginTextField.getText();
    validateForm();
  }

  @Override
  public void validatePassword() {
    password = passwordTextField.getText();
    validateForm();
  }

  void validateForm() {
    if ((passwordTextField != null && passwordTextField.getText().length() < 6) || (loginTextField != null && loginTextField.getText().length() < 3)) {
      setLoginButtonStatus(true);
    } else {
      setLoginButtonStatus(false);
    }
  }

  public void setLoginButtonStatus(boolean value) {
    this.loginButton.setDisable(value);
  }

  @Override
  public void auth() throws Exception {
    String result = userAuthentication.auth(new AuthenticationParams(login, password));
    System.out.println(result);
    if (result != null) {
      loadHomePage();
    }
  }

  @Override
  public void loadHomePage() throws Exception {
    UUID clinicUUID = UUID.randomUUID();
    UUID receptionistUUID = UUID.randomUUID();
    List<String> permissions = Arrays.asList("SCHEDULE");
    UserPermissions userPermissions = new UserPermissions(receptionistUUID.toString(), permissions);
    Receptionist receptionist = new Receptionist(receptionistUUID.toString(), "Ana Silva", "ana", "123456", userPermissions);
    Assistent assistent = new Assistent(UUID.randomUUID().toString(), "Gabriel", "gabriel", "123456", null);
    Orthodontist orthodontist = new Orthodontist(UUID.randomUUID().toString(), "Joao", "joao", "123456", null);
    orthodontist.setAssistent(assistent);
    Clinic clinic = new Clinic(clinicUUID.toString(), receptionist, null);
    clinic.getOrthodontists().add(orthodontist);
    clinic.getAssistents().add(assistent);
    Stage homeStage = new Stage();
    this.homePage = new HomePage(new PresentationHomeController(clinic, homeStage));
    stage.close();
    homePage.build(homeStage);
  }
}
