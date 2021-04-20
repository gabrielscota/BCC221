package presentation.controllers;

import data.usecases.assistent.LocalAddAssistent;
import data.usecases.orthodontist.LocalAddOrthodontist;
import domain.entities.*;
import domain.usecases.assistent.AddAssistent;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableStringValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import ui.pages.employees.EmployeeController;
import javafx.stage.Stage;
import domain.usecases.orthodontist.AddOrthodontist;
import domain.usecases.orthodontist.DeleteOrthodontist;
import domain.usecases.orthodontist.EditOrthodontist;

import javax.swing.event.ChangeEvent;
import javax.xml.soap.Text;

import java.util.*;

public class PresentationEmployeeController implements EmployeeController {
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
  TableView<Employee> employees;
  @FXML
  TableColumn<Employee, String> idColumn;
  @FXML
  TableColumn<Employee, String> nameColumn;
  @FXML
  TableColumn<Employee, String> typeColumn;
  @FXML
  Button addEmployeeButton = new Button();
  @FXML
  Button saveEmployeeButton = new Button();
  @FXML
  Button deleteEmployeeButton = new Button();

  public PresentationEmployeeController(Stage stage, Stage backStage, Clinic clinic) {
    this.backStage = backStage;
    this.stage = stage;
    this.clinic = clinic;
    this.employees = new TableView<Employee>();
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

  }

  @Override
  public void showEmployeesTable() {
    addEmployeeButton.setDisable(false);
    saveEmployeeButton.setDisable(true);
    deleteEmployeeButton.setDisable(true);
    List<Assistent> assistents = clinic.getAssistents();
    List<Orthodontist> orthodontists = clinic.getOrthodontists();
    ObservableList<Employee> observableList = FXCollections.observableArrayList();
    if (!orthodontists.isEmpty()) {
      observableList.addAll(orthodontists);
    }
    if (!assistents.isEmpty()) {
      observableList.addAll(assistents);
    }
    idColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("id"));
    nameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
    typeColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Employee, String>, ObservableValue<String>>() {
      @Override
      public ObservableValue<String> call(TableColumn.CellDataFeatures<Employee, String> param) {
        ObservableStringValue value = new ObservableStringValue() {
          @Override
          public String get() {
            return null;
          }

          @Override
          public void addListener(ChangeListener<? super String> listener) {

          }

          @Override
          public void removeListener(ChangeListener<? super String> listener) {

          }

          @Override
          public String getValue() {
            String simpleName = param.getValue().getClass().getSimpleName();
            switch (simpleName) {
              case "Orthodontist":
                return "Ortodontista";
              case "Assistent":
                return "Assistente";
            }
            return simpleName;
          }

          @Override
          public void addListener(InvalidationListener listener) {

          }

          @Override
          public void removeListener(InvalidationListener listener) {

          }
        };
        return value;
      }
    });
    employees.setItems(observableList);
  }

  @Override
  public void onSelectedEmployee() {
    Employee selectedEmployee = employees.getSelectionModel().getSelectedItem();
    if (selectedEmployee != null) {
      nameTextField.setText(selectedEmployee.getName());
      userLoginTextField.setText(selectedEmployee.getLogin());
      passwordTextField.setText(selectedEmployee.getPassword());
      String classSimpleName = selectedEmployee.getClass().getSimpleName().equals("Orthodontist") ? "Ortodontista" : "Assistente";
      comboBoxType.setValue(classSimpleName);
      addEmployeeButton.setDisable(true);
      saveEmployeeButton.setDisable(false);
      deleteEmployeeButton.setDisable(false);
    }
  }

  @Override
  public void addEmployee() {
    if (validateCombobox() && validateName() && validateUser() && validatePassword()) {
      if (comboBoxType.getValue().equals("Ortodontista")) {
        addOrthodontistTable();
      } else {
        addAssistentTable();
      }
      nameTextField.setText("");
      userLoginTextField.setText("");
      passwordTextField.setText("");
      comboBoxType.setValue("");
    } else {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Dados invalidos");
      alert.setHeaderText("Preencha corretamente todos os campos");
      alert.setContentText("Nome, usuario e senha devem possuir mais de 3 caracteres.");
      alert.show();
    }
  }

  @Override
  public void populateCombobox() {
    ObservableList obsList = FXCollections.observableArrayList();
    obsList.add("Ortodontista");
    obsList.add("Assistente");
    comboBoxType.setItems(obsList);
  }

  @Override
  public boolean validateName() {
    if (nameTextField.getText().length() < 3) {
      return false;
    }
    return true;
  }

  @Override
  public boolean validateUser() {
    if (nameTextField.getText().length() < 3) {
      return false;
    }
    return true;
  }

  @Override
  public boolean validatePassword() {
    if (passwordTextField.getText().length() < 3) {
      return false;
    }
    return true;
  }

  @Override
  public boolean validateCombobox() {
    if (comboBoxType.getValue().equals("")) {
      return false;
    }
    return true;
  }
}
