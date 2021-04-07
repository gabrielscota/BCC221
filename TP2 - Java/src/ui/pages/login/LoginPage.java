package ui.pages.login;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginPage {
  private final LoginController loginController;

  public LoginPage(LoginController loginController) {
    this.loginController = loginController;
  }

  public void build(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
    primaryStage.setTitle("Login | Clínica Odontológica");
    primaryStage.setScene(new Scene(root));
    primaryStage.setResizable(false);
    primaryStage.show();
  }
}
