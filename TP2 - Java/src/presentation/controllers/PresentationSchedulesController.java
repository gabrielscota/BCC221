package presentation.controllers;


import domain.entities.Clinic;
import domain.entities.Consultation;
import domain.entities.Orthodontist;
import domain.entities.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import ui.pages.schedules.SchedulesController;


import java.util.List;
import java.util.UUID;

public class PresentationSchedulesController implements SchedulesController {
  private Stage stage;
  private Stage backStage;
  private Clinic clinic;
  private Orthodontist selectedOrthodontist;
  private int indexSelectedOrthodontist;
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
  TableColumn<Consultation, String> description;
  @FXML
  TableColumn<Consultation, String> date;
  @FXML
  TableColumn<Consultation, String> name;
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
    ObservableList obsList = FXCollections.observableArrayList();
    for (int i = 0; i < ortodontistas.size(); i++){
      if(ortodontistas.get(i).getName() == comboBoxOrthodontists.getValue()){
        this.selectedOrthodontist = ortodontistas.get(i);
        indexSelectedOrthodontist = i;
        List<Consultation> consultations = ortodontistas.get(i).getSchedule().getConsultations();
        obsList.addAll(consultations);
      }
    }
    name.setCellValueFactory(new PropertyValueFactory<Consultation, String>("name"));
    description.setCellValueFactory(new PropertyValueFactory<Consultation, String>("description"));
    date.setCellValueFactory(new PropertyValueFactory<Consultation, String>("date"));
    consultations.setItems(obsList);
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
    if(validateCombobox() && validatePatientName() && validateDate() && validateDescription()){
      UUID uuid = UUID.randomUUID();
      UUID patientUuid = UUID.randomUUID();
      Patient newPatient = new Patient(patientUuid.toString(), nameTextField.getText());
      clinic.getPatients().add(newPatient);
      Consultation newConsultation = new Consultation(
              uuid.toString(),
              newPatient,
              dateTextField.getText(),
              descriptionTextField.getText(),
              null
      );
      selectedOrthodontist.getSchedule().getConsultations().add(newConsultation);
      clinic.getOrthodontists().set(indexSelectedOrthodontist, selectedOrthodontist);
      updateTable();
    }
  }

  @Override
  public boolean validateCombobox() {
    if(comboBoxOrthodontists.getValue() == null || comboBoxOrthodontists.getValue() == ""){
      return false;
    }
    return true;
  }

  @Override
  public boolean validatePatientName() {
    if(nameTextField.getText() == ""){
      return false;
    }else {
      return true;
    }
  }

  @Override
  public boolean validateDate() {
    if(dateTextField.getText() == ""){
      return false;
    }else {
      return true;
    }
  }

  @Override
  public boolean validateDescription() {
    if(descriptionTextField.getText() == ""){
      return false;
    }else {
      return true;
    }
  }
}
