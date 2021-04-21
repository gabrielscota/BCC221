package presentation.controllers;

import data.usecases.assistent.LocalAddAssistent;
import data.usecases.assistent.LocalDeleteAssistent;
import data.usecases.orthodontist.LocalAddOrthodontist;
import data.usecases.orthodontist.LocalDeleteOrthodontist;
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
import ui.pages.time_sheet.TimeSheetPage;

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
  @FXML
  Button timeSheetEmployeeButton = new Button();

  public PresentationEmployeeController(Stage stage, Stage backStage, Clinic clinic) {
    this.backStage = backStage;
    this.stage = stage;
    this.clinic = clinic;
    this.employees = new TableView<Employee>();
  }

  @Override
  public void addEmployeeToClinic(String type) {
    if (type.equals("Ortodontista")) {
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
    } else {
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
    }
    showEmployeesTable();
  }

  @Override
  public void showEmployeesTable() {
    addEmployeeButton.setDisable(false);
    saveEmployeeButton.setDisable(true);
    deleteEmployeeButton.setDisable(true);
    timeSheetEmployeeButton.setDisable(true);
    timeSheetEmployeeButton.setVisible(false);
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
    employees.refresh();
  }

  @Override
  public void onSelectedEmployee() {
    Employee selectedEmployee = employees.getSelectionModel().getSelectedItem();
    if (selectedEmployee != null) {
      nameTextField.setText(selectedEmployee.getName());
      userLoginTextField.setText(selectedEmployee.getLogin());
      passwordTextField.setText(selectedEmployee.getPassword());
      String classSimpleName;
      if (selectedEmployee instanceof Orthodontist) {
        classSimpleName = "Ortodontista";
      } else {
        classSimpleName = "Assistente";
      }
      comboBoxType.setValue(classSimpleName);
      addEmployeeButton.setDisable(true);
      saveEmployeeButton.setDisable(false);
      deleteEmployeeButton.setDisable(false);
      timeSheetEmployeeButton.setDisable(false);
      timeSheetEmployeeButton.setVisible(true);
    }
  }

  @Override
  public void addEmployee() {
    if (validateCombobox() && validateName() && validateUser() && validatePassword()) {
      if (comboBoxType.getValue().equals("Ortodontista") || comboBoxType.getValue().equals("Assistente")) {
        addEmployeeToClinic(comboBoxType.getValue());
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
  public void saveEmployee() {
    Employee selectedEmployee = employees.getSelectionModel().getSelectedItem();
    if (selectedEmployee != null) {
      selectedEmployee.setName(nameTextField.getText());
      selectedEmployee.setLogin(userLoginTextField.getText());
      selectedEmployee.setPassword(passwordTextField.getText());
      nameTextField.setText("");
      userLoginTextField.setText("");
      passwordTextField.setText("");
      comboBoxType.setValue("");
      employees.getSelectionModel().clearSelection();
      showEmployeesTable();
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Sucesso!");
      alert.setHeaderText("Funcionário editado com sucesso!");
      alert.show();
    }
  }

  @Override
  public void deleteEmployee() {
    Employee selectedEmployee = employees.getSelectionModel().getSelectedItem();
    if (selectedEmployee != null) {
      if (selectedEmployee instanceof Orthodontist) {
        LocalDeleteOrthodontist localDeleteOrthodontist = new LocalDeleteOrthodontist(clinic);
        localDeleteOrthodontist.deleteOrthodontist(selectedEmployee.getId());
      } else {
        LocalDeleteAssistent localDeleteAssistent = new LocalDeleteAssistent(clinic);
        localDeleteAssistent.deleteAssistent(selectedEmployee.getId());
      }
      nameTextField.setText("");
      userLoginTextField.setText("");
      passwordTextField.setText("");
      comboBoxType.setValue("");
      employees.getSelectionModel().clearSelection();
      showEmployeesTable();
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Sucesso!");
      alert.setHeaderText("Funcionário editado com sucesso!");
      alert.show();
    }
  }

  @Override
  public void loadTimeSheetPage() throws Exception {
    Employee selectedEmployee = employees.getSelectionModel().getSelectedItem();
    if (selectedEmployee != null) {
      Stage timeSheetStage = new Stage();
      TimeSheetPage timeSheetPage = new TimeSheetPage(new PresentationTimeSheetController(
              timeSheetStage,
              stage,
              selectedEmployee.getTimeSheet()
      ));
      timeSheetPage.build(timeSheetStage);
//      stage.close();
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

  @Override
  public void backPage() {
    backStage.show();
    stage.close();
  }
}
