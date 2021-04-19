package ui.pages.receptionist;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ReceptionistPage {
  private final ReceptionistController receptionistController;

  public ReceptionistPage(ReceptionistController receptionistController) {
    this.receptionistController = receptionistController;
  }

  public void build(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("receptionist.fxml"));
    loader.setControllerFactory(c -> receptionistController);
    Parent root = loader.load();
    primaryStage.setTitle("Recepcionista | Clínica Odontológica");
    primaryStage.setScene(new Scene(root));
    primaryStage.setResizable(false);
    primaryStage.show();
  }
}
