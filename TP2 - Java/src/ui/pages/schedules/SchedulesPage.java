package ui.pages.schedules;

import domain.entities.Employee;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SchedulesPage {
  private Stage stage;
  private SchedulesController schedulesController;

  public SchedulesPage(SchedulesController schedulesController){
    this.schedulesController = schedulesController;
  }
  public void build(Stage primaryStage) throws Exception{
    this.stage = primaryStage;
    FXMLLoader loader = new FXMLLoader(getClass().getResource("schedules.fxml"));
    loader.setControllerFactory(controller -> schedulesController);
    Parent root = loader.load();
    primaryStage.setTitle("Gerenciar agendas");
    primaryStage.setScene(new Scene(root));
    primaryStage.setResizable(false);
    schedulesController.populateCombobox();
    primaryStage.show();
  }
}
