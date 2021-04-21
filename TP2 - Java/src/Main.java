import data.usecases.authentication.LocalAuthentication;
import javafx.application.Application;
import javafx.stage.Stage;
import presentation.controllers.PresentationLoginController;
import ui.pages.login.LoginPage;

public class Main extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    // Chama a tela de Login para acessar o sistema
    LoginPage loginPage = new LoginPage(new PresentationLoginController(new LocalAuthentication(), primaryStage));
    loginPage.build(primaryStage);
  }
}
