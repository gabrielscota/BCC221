package ui.pages.login;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginPage {
  private final LoginController loginController;
  private Stage stage;

  public LoginPage(LoginController loginController) {
    this.loginController = loginController;
  }

  public void build(Stage stage) throws Exception {
    this.stage = stage;
    FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
    loader.setControllerFactory(controller -> loginController);
    Parent root = loader.load();
    stage.setTitle("Login | Clínica Odontológica");
    stage.setScene(new Scene(root));
    stage.setResizable(false);
    stage.show();
    loginController.setLoginButtonStatus(true);
  }

  public void close() {
    stage.close();
  }
}
