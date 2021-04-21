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
  private int selectedOrthodontistIndex;
  @FXML
  ComboBox<String> comboBoxConsultations;
  @FXML
  ComboBox<String> comboBoxPatients;
  @FXML
  ComboBox<String> comboBoxOrthodontist;
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
  //Faz o controle da navegação entre paginas. Fecha a pagina atual e abre a anterior dando função ao botao voltar;
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
  //Popula o combobox para o funcionario escolher uma consulta para pagar
  public void populateComboboxConsultations(){
    String orthodontistName = comboBoxOrthodontist.getValue();
    ObservableList obsList = FXCollections.observableArrayList();
    List<Orthodontist> orthodontists = clinic.getOrthodontists();
    List<Consultation> consultations = new ArrayList<Consultation>();
    for(int i = 0; i < orthodontists.size(); i ++){
      if(orthodontistName == orthodontists.get(i).getName()){
        consultations = orthodontists.get(i).getSchedule().getConsultations();
      }
    }
    for(int i = 0; i < consultations.size(); i++){
      obsList.add(consultations.get(i).getDate());
    }
    comboBoxConsultations.setItems(obsList);
  }

  @Override
  //Popula o combobox com os ortodontistas
  public void populateComboboxOrthodontist() {
    List<Orthodontist> orthodontists = clinic.getOrthodontists();
    ObservableList obsList = FXCollections.observableArrayList();
    for(int i = 0; i < orthodontists.size(); i++){
      obsList.add(orthodontists.get(i).getName());
    }
    comboBoxOrthodontist.setItems(obsList);
  }

  @Override
  //Popula o combobox para o funcionario escolher um paciente
  public void populateComboboxPatients() {
    String date = comboBoxConsultations.getValue();
    ObservableList obsList = FXCollections.observableArrayList();
    List<Orthodontist> orthodontists = clinic.getOrthodontists();
    List<Consultation> consultations = new ArrayList<Consultation>();
    for(int i = 0; i < orthodontists.size(); i ++){
        consultations = orthodontists.get(i).getSchedule().getConsultations();
      for(int j = 0; j < consultations.size(); j++){
        if (consultations.get(j).getDate() == date){
          obsList.add(consultations.get(i).getPatient().getName());
        }
      }
    }
    comboBoxConsultations.setItems(obsList);
  }

  @Override
  //Adiciona um paiymentconsultation as consultas pagas.
  public void addPaidConsultation() {
    List<Orthodontist> orthodontistList = clinic.getOrthodontists();
    List<Consultation> consultations = new ArrayList<Consultation>();
    String selectedOrthodontist = comboBoxOrthodontist.getValue();
    String selectedDate = comboBoxConsultations.getValue();
    for(int i = 0; i < orthodontistList.size(); i++){
      if(orthodontistList.get(i).getName() == selectedOrthodontist){
        consultations = orthodontistList.get(i).getSchedule().getConsultations();
        for (int j = 0; j < consultations.size(); j++){
          if(consultations.get(j).getDate() == selectedDate){
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String formatedDate = dateFormat.format(date);
            PaymentConsultation payment = new PaymentConsultation(
                    consultations.get(j).getId(),
                    comboBoxPatients.getValue(),
                    formatedDate,
                    Float.parseFloat(valueTextField.getText())
            );
            consultations.get(j).setPaymentConsultation(payment);
          }
        }
      }
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
