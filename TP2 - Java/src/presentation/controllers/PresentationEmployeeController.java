package presentation.controllers;

import com.sun.org.apache.xpath.internal.operations.Or;
import data.usecases.orthodontist.LocalAddOrthodontist;
import domain.entities.*;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import ui.pages.employees.EmployeeController;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import domain.usecases.orthodontist.AddOrthodontist;
import domain.usecases.orthodontist.DeleteOrthodontist;
import domain.usecases.orthodontist.EditOrthodontist;
import javax.xml.soap.Text;
import javafx.scene.control.TextField;
import java.util.Arrays;
import java.util.UUID;

public class PresentationEmployeeController implements EmployeeController{
  private Stage stage;
  private Stage backStage;
  private Clinic clinic;
  @FXML
  TextField nameTextField = new TextField();
  @FXML
  TextField passwordTextField = new TextField();
  @FXML
  TextField userLoginTextField = new TextField();
  @FXML
  TableView <TableEmployees> employees;
  @FXML
  TableColumn <TableEmployees, String> idColumn;
  @FXML
  TableColumn <TableEmployees, String> nameColumn;
  @FXML
  TableColumn <TableEmployees, String> typeColumn;

  public PresentationEmployeeController(Stage stage, Stage backStage, Clinic clinic){
    this.backStage = backStage;
    this.stage = stage;
    this.clinic = clinic;
  }

  @Override
  public void addOrthodontistTable() {
    AddOrthodontist addOrthodontist = new LocalAddOrthodontist(clinic);
    UUID orthodontistId = UUID.randomUUID();
    Orthodontist newOrthodontist = new Orthodontist(
            orthodontistId.toString(),
            nameTextField.getText(),
            userLoginTextField.getText(),
            passwordTextField.getText(),
            null
    );
    addOrthodontist.addOrthodontist(newOrthodontist);
  }

  @Override
  public void editOrthodontistTable() {

  }

  @Override
  public void deleteOrthodontistTable() {

  }

  @Override
  public void addAssistentTable() {


  }

  @Override
  public void editAssistentTable() {

  }

  @Override
  public void deleteAssistentTable() {

  }
  @Override
  public void showEmployeesTable(){

  }
}
