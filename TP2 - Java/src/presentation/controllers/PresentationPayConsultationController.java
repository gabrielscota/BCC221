package presentation.controllers;

import com.sun.org.apache.xpath.internal.operations.Or;
import data.usecases.schedule.LocalAddConsultation;
import data.usecases.schedule.LocalLoadConsultations;
import domain.entities.*;
import domain.usecases.schedule.AddConsultation;
import domain.usecases.schedule.DeleteConsultation;
import domain.usecases.schedule.EditConsultation;
import domain.usecases.schedule.LoadConsultations;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import ui.pages.payConsultations.PayConsultationController;
import ui.pages.payConsultations.PayConsultationPage;

import javax.xml.soap.Text;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PresentationPayConsultationController implements PayConsultationController {
  private final Clinic clinic;
  private final Stage stage;
  private final Stage backStage;
  @FXML
  ComboBox<String> comboBoxConsultations;
  @FXML
  TextField valueTextField = new TextField();
  @FXML
  TextField nameTextField = new TextField();
  @FXML
  TableView <PaymentConsultation> consultationsTable;
  @FXML
  TableColumn<PaymentConsultation, String> patientName;
  @FXML
  TableColumn<PaymentConsultation, Float> value;
  @FXML
  TableColumn<PaymentConsultation, String> date;
  public PresentationPayConsultationController(Clinic clinic, Stage stage, Stage backStage) {
      this.clinic = clinic;
      this.stage = stage;
      this.backStage = backStage;
      this.consultationsTable = new TableView<PaymentConsultation>();
  }

  @Override
  public boolean validateValue() {
    if(valueTextField.getText() == ""){
      return false;
    }
    return true;
  }

  @Override
  public void backPage() {
    backStage.show();
    stage.close();
  }

  @Override
  public boolean validatePatientName() {
    if(nameTextField.getText().length() < 3){
      return false;
    }
    return true;
  }
  @Override
  public void populateCombobox(){
    ObservableList obsList = FXCollections.observableArrayList();
    List<Orthodontist> orthodontistList = clinic.getOrthodontists();
    List<Consultation> consultations = new ArrayList<Consultation>();
    for (int i = 0; i <orthodontistList.size(); i++){
      LoadConsultations loadConsultations = new LocalLoadConsultations(orthodontistList.get(i).getSchedule());
      List<Consultation> consultationsLoaded = loadConsultations.loadConsultations();
      System.out.println(consultationsLoaded.get(0).getDate());
      for(int j = 0; j < consultationsLoaded.size(); j++){
        obsList.add("Consulta de: " + consultationsLoaded.get(i).getPatient().getName() + "  | " + "Dia: " + consultationsLoaded.get(i).getDate());
      }
    }
    comboBoxConsultations.setItems(obsList);
  }
  @Override
  public void addPaidConsultation() {
    List<Orthodontist> orthodontistList = clinic.getOrthodontists();
    List<Consultation> consultations = new ArrayList<Consultation>();
    for (int i = 0; i <orthodontistList.size(); i++){
      LoadConsultations loadConsultations = new LocalLoadConsultations(orthodontistList.get(i).getSchedule());
      List<Consultation> contationsLoaded = loadConsultations.loadConsultations();
      for(int j = 0; j < contationsLoaded.size(); j++){
        consultations.add(contationsLoaded.get(i));
      }
    }
    if(validatePatientName() && validateValue()){
      for (int i = 0; i < consultations.size(); i ++){
        if(consultations.get(i).getPatient().getName() == nameTextField.getText()){
          Date date = new Date();
          DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
          String formatedDate = dateFormat.format(date);
          PaymentConsultation payment = new PaymentConsultation(
                  consultations.get(i).getId(),
                  consultations.get(i).getPatient().getName(),
                  formatedDate,
                  Float.parseFloat(valueTextField.getText())
          );
          consultations.get(i).setPaymentConsultation(payment);
        }
      }
    }
    else{
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Dados invalidos");
      alert.setHeaderText("Preencha corretamente todos os campos");
      alert.setContentText("O nome do paciente deve ter mais de 3 caracteres");
      alert.show();
    }
    showConsultationsTable();
  }

  @Override
  public void showConsultationsTable() {
    ObservableList<PaymentConsultation> paidConsultations = FXCollections.observableArrayList();
    List<Orthodontist> orthodontistList = clinic.getOrthodontists();
    List<Consultation> consultations = new ArrayList<Consultation>();
    for (int i = 0; i <orthodontistList.size(); i++){
      LoadConsultations loadConsultations = new LocalLoadConsultations(orthodontistList.get(i).getSchedule());
      List<Consultation> contationsLoaded = loadConsultations.loadConsultations();
      for(int j = 0; j < contationsLoaded.size(); j++){
        consultations.add(contationsLoaded.get(i));
      }
    }

    patientName.setCellValueFactory(new PropertyValueFactory<PaymentConsultation, String>("name"));
    date.setCellValueFactory(new PropertyValueFactory<PaymentConsultation, String>("paymentDate"));
    value.setCellValueFactory(new PropertyValueFactory<PaymentConsultation, Float>("value"));
    consultationsTable.setItems(paidConsultations);
  }
}
