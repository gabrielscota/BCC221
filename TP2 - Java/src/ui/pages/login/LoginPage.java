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

  public void build(Stage primaryStage) throws Exception {
    this.stage = primaryStage;
    FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
    loader.setControllerFactory(c -> loginController);
    Parent root = loader.load();
    primaryStage.setTitle("Login | Clínica Odontológica");
    primaryStage.setScene(new Scene(root));
    primaryStage.setResizable(false);
    primaryStage.show();
  }
  public void close() {
    stage.close();
  }
}
