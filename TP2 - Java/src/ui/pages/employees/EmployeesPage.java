package ui.pages.employees;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EmployeesPage {

  private Stage stage;
  private EmployeeController employeeController;

  public EmployeesPage(EmployeeController employeeController){
    this.employeeController = employeeController;
  }
  public void build(Stage primaryStage) throws Exception{
    this.stage = primaryStage;
    FXMLLoader loader = new FXMLLoader(getClass().getResource("employees.fxml"));
    loader.setControllerFactory(c -> employeeController);
    Parent root = loader.load();
    primaryStage.setTitle("Funcionários");
    primaryStage.setScene(new Scene(root));
    primaryStage.setResizable(false);
    primaryStage.show();
    employeeController.populateCombobox();
  }
}
