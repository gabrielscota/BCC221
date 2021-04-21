import data.usecases.authentication.LocalAuthentication;
import javafx.application.Application;
import javafx.stage.Stage;
import presentation.controllers.PresentationLoginController;
import ui.pages.login.LoginPage;

public class Main extends Application {
  public static void main(String[] args) {
    launch(args);
  }
  //Esse é o arquivo Raiz do projeto. Aqui é inicializada a tela de login. Dessa tela de login vao partir todas outras telas
  @Override
  public void start(Stage primaryStage) throws Exception {
    // Chama a tela de Login para acessar o sistema
    LoginPage loginPage = new LoginPage(new PresentationLoginController(new LocalAuthentication(), primaryStage));
    //Iniciando login page
    loginPage.build(primaryStage);
  }
}
