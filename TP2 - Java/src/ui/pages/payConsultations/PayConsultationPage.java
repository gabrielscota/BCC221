package ui.pages.payConsultations;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.pages.employees.EmployeeController;

public class PayConsultationPage {
  private Stage stage;
  private PayConsultationController consultationController;

  public PayConsultationPage(PayConsultationController consultationController){
    this.consultationController = consultationController;
  }
  public void build(Stage primaryStage) throws Exception{
    this.stage = primaryStage;
    FXMLLoader loader = new FXMLLoader(getClass().getResource("payConsultations.fxml"));
    loader.setControllerFactory(c -> consultationController);
    Parent root = loader.load();
    primaryStage.setTitle("Receber Consulta");
    primaryStage.setScene(new Scene(root));
    primaryStage.setResizable(false);
    primaryStage.show();
    consultationController.showConsultationsTable();
  }
}
