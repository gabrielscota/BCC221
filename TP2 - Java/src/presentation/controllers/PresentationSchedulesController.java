package presentation.controllers;


import domain.entities.Clinic;
import domain.entities.Consultation;
import domain.entities.Orthodontist;
import domain.entities.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import ui.pages.schedules.SchedulesController;


import java.util.List;

public class PresentationSchedulesController implements SchedulesController {
  private Stage stage;
  private Stage backStage;
  private Clinic clinic;

  @FXML
  ComboBox<String> comboBoxOrthodontists;
  @FXML
  TextField nameTextField;
  @FXML
  TextField dateTextField;
  @FXML
  TextArea descriptionTextField;
  @FXML
  TableView<Consultation> consultations;
  @FXML
  TableColumn<Orthodontist, String> orthodontist;
  @FXML
  TableColumn<Consultation, String> date;
  @FXML
  TableColumn<Patient, String> name;
  @FXML
  Button addConsultationButton = new Button();
  @FXML
  Button editConsultationButton = new Button();
  @FXML
  Button deleteConsultationButton = new Button();

  public PresentationSchedulesController(Stage stage, Stage backStage, Clinic clinic){
    this.stage = stage;
    this.backStage = backStage;
    this.clinic = clinic;
  }

  @Override
  public void backPage() {
    stage.close();
    backStage.show();
    System.out.println(backStage.getClass().getName());

  }

  @Override
  public void updateTable() {
    List<Orthodontist> ortodontistas = clinic.getOrthodontists();
  }

  @Override
  public void populateCombobox() {
    List<Orthodontist> orthodontists = clinic.getOrthodontists();
    ObservableList obsList = FXCollections.observableArrayList();
    for (int i = 0; i < orthodontists.size(); i ++){
      obsList.add(orthodontists.get(i).getName());
    }
    comboBoxOrthodontists.setItems(obsList);
  }

  @Override
  public void addConsultation() {

  }

  @Override
  public boolean validateCombobox() {
    return false;
  }

  @Override
  public boolean validatePatientName() {
    return false;
  }

  @Override
  public boolean validateDate() {
    return false;
  }

  @Override
  public boolean validateDescription() {
    return false;
  }
}
