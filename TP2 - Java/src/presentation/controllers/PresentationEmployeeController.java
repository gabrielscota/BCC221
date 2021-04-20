package presentation.controllers;

import com.sun.org.apache.xpath.internal.operations.Or;
import data.usecases.assistent.LocalAddAssistent;
import data.usecases.orthodontist.LocalAddOrthodontist;
import domain.entities.*;
import domain.usecases.assistent.AddAssistent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import ui.pages.employees.EmployeeController;
import javafx.stage.Stage;
import domain.usecases.orthodontist.AddOrthodontist;
import domain.usecases.orthodontist.DeleteOrthodontist;
import domain.usecases.orthodontist.EditOrthodontist;
import javax.xml.soap.Text;

import java.util.*;

public class PresentationEmployeeController implements EmployeeController{
  private Stage stage;
  private Stage backStage;
  private Clinic clinic;
  @FXML
  ComboBox<String> comboBoxType;
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
  @FXML
  TableColumn <TableEmployees, Boolean>selectCol;
  public PresentationEmployeeController(Stage stage, Stage backStage, Clinic clinic){
    this.backStage = backStage;
    this.stage = stage;
    this.clinic = clinic;
    this.employees = new TableView<TableEmployees>();
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
    showEmployeesTable();
  }

  @Override
  public void editOrthodontistTable() {

  }

  @Override
  public void deleteOrthodontistTable() {

  }

  @Override
  public void addAssistentTable() {
    AddAssistent addAssistent = new LocalAddAssistent(clinic);
    UUID assistentUUID = UUID.randomUUID();
    Assistent newAssistent = new Assistent(
            assistentUUID.toString(),
            nameTextField.getText(),
            userLoginTextField.getText(),
            passwordTextField.getText(),
            null
    );
    addAssistent.addAssistent(newAssistent);
    showEmployeesTable();
  }

  @Override
  public void editAssistentTable() {

  }

  @Override
  public void deleteAssistentTable() {
    System.out.println(selectCol.getText());
  }
  @Override
  public void showEmployeesTable(){
    List<Assistent> assistents = clinic.getAssistents();
    List<Orthodontist> orthodontists = clinic.getOrthodontists();
    List<TableEmployees> employeesList  = new ArrayList<TableEmployees>();
    ObservableList<TableEmployees> observableList = FXCollections.observableArrayList();
    if (!orthodontists.isEmpty()) {
      for (int i = 0; i < orthodontists.size(); i++) {
          TableEmployees tableEmployees = new TableEmployees(
                  orthodontists.get(i).getName(),
                  orthodontists.get(i).getId(),
                  "Ortodontista"
                  );
          observableList.add(tableEmployees);
        }
      }
    if (!assistents.isEmpty()) {
      for (int i = 0; i < assistents.size(); i++) {
        TableEmployees tableEmployees = new TableEmployees(
                assistents.get(i).getName(),
                assistents.get(i).getId(),
                "Assistente"
        );
        observableList.add(tableEmployees);
      }
    }
    idColumn.setCellValueFactory(new PropertyValueFactory<TableEmployees, String>("id"));
    nameColumn.setCellValueFactory(new PropertyValueFactory<TableEmployees, String>("name"));
    typeColumn.setCellValueFactory(new PropertyValueFactory<TableEmployees, String>("type"));
    employees.setItems(observableList);
    }
    @Override
    public void addEmployee(){
      if(validateCombobox() && validateName() && validateUser() && validatePassword()){
        if(comboBoxType.getValue() == "Ortodontista"){
          addOrthodontistTable();
        }
        else{
          addAssistentTable();
        }
        nameTextField.setText("");
        userLoginTextField.setText("");
        passwordTextField.setText("");
        comboBoxType.setValue("");
      }
      else{
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Dados invalidos");
        alert.setHeaderText("Preencha corretamente todos os campos");
        alert.setContentText("Nome, usuario e senha devem possuir mais de 3 caracteres.");
        alert.show();
      }
    }
    @Override
    public void populateCombobox(){
      ObservableList obsList = FXCollections.observableArrayList();
      obsList.add("Ortodontista");
      obsList.add("Assistente");
      comboBoxType.setItems(obsList);
    }
  @Override
  public boolean validateName() {
    if(nameTextField.getText().length() < 3){
      return false;
    }
    return true;
  }
  @Override
  public boolean validateUser() {
    if(nameTextField.getText().length() < 3){
      return false;
    }
    return true;
  }
  @Override
  public boolean validatePassword() {
    if(passwordTextField.getText().length() < 3){
      return false;
    }
    return true;
  }
  @Override
  public boolean validateCombobox() {
    if(comboBoxType.getValue() == ""){
      return false;
    }
    return true;
  }
  @Override
  public void backPage(){
    backStage.show();
    stage.close();
  }
}
