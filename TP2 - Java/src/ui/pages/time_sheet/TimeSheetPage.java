package ui.pages.time_sheet;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TimeSheetPage {
  private Stage stage;
  private TimeSheetController timeSheetController;

  public TimeSheetPage(TimeSheetController timeSheetController) {
    this.timeSheetController = timeSheetController;
  }

  public void build(Stage primaryStage) throws Exception {
    this.stage = primaryStage;
    FXMLLoader loader = new FXMLLoader(getClass().getResource("time_sheet.fxml"));
    loader.setControllerFactory(controller -> timeSheetController);
    Parent root = loader.load();
    primaryStage.setTitle("Folha de ponto");
    primaryStage.setScene(new Scene(root));
    primaryStage.setResizable(false);
    timeSheetController.showPointsTable();
    primaryStage.show();
  }
}
