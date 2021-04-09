package ui.pages.login;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginPage {
  private final LoginController loginController;

  public LoginPage(LoginController loginController) {
    this.loginController = loginController;
  }

  public void build(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));

    loader.setControllerFactory(c -> loginController);
    Parent root = loader.load();

    primaryStage.setTitle("Login | Clínica Odontológica");
    primaryStage.setScene(new Scene(root));
    primaryStage.setResizable(false);
    primaryStage.show();
  }
}
