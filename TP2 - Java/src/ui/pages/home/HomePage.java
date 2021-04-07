package ui.pages.home;

import domain.entities.Consultation;
import domain.entities.Schedule;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.pages.login.LoginController;

import java.util.List;

public class HomePage {
  private final HomeController homeController;

  public HomePage(HomeController homeController) {
    this.homeController = homeController;
  }

  public void build(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
    primaryStage.setTitle("Inicio | Clínica Odontológica");
    primaryStage.setScene(new Scene(root));
    primaryStage.setResizable(false);
    primaryStage.show();
  }
}
