package presentation.controllers;

import data.usecases.time_sheet.LocalAddPoint;
import data.usecases.time_sheet.LocalDeletePoint;
import domain.entities.*;
import domain.usecases.time_sheet.AddPoint;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import ui.pages.time_sheet.TimeSheetController;

import java.util.List;
import java.util.UUID;

public class PresentationTimeSheetController implements TimeSheetController {
  private Stage stage;
  private Stage backStage;
  private TimeSheet timeSheet;

  @FXML
  TextField dateTextField = new TextField();
  @FXML
  TextField observationTextField = new TextField();
  @FXML
  TableView<Point> points;
  @FXML
  TableColumn<Point, String> idColumn;
  @FXML
  TableColumn<Point, String> dateColumn;
  @FXML
  TableColumn<Point, String> observationColumn;
  @FXML
  Button addPointButton = new Button();
  @FXML
  Button savePointButton = new Button();
  @FXML
  Button deletePointButton = new Button();

  public PresentationTimeSheetController(Stage stage, Stage backStage, TimeSheet timeSheet) {
    this.backStage = backStage;
    this.stage = stage;
    this.timeSheet = timeSheet;
    this.points = new TableView<Point>();
  }

  @Override
  public void addPointToTimeSheet() {
    AddPoint addPoint = new LocalAddPoint(timeSheet);
    Point newPoint = new Point(
            UUID.randomUUID().toString(),
            dateTextField.getText(),
            observationTextField.getText()
    );
    addPoint.addPoint(newPoint);
    System.out.println("Ponto adicionado!");
    showPointsTable();
  }

  @Override
  public void showPointsTable() {
    addPointButton.setDisable(false);
    savePointButton.setDisable(true);
    deletePointButton.setDisable(true);
    List<Point> timeSheetPoints = timeSheet.getPoints();
    ObservableList<Point> observableList = FXCollections.observableArrayList();
    if (!timeSheetPoints.isEmpty()) {
      observableList.addAll(timeSheetPoints);
    }

    idColumn.setCellValueFactory(new PropertyValueFactory<Point, String>("id"));
    dateColumn.setCellValueFactory(new PropertyValueFactory<Point, String>("date"));
    observationColumn.setCellValueFactory(new PropertyValueFactory<Point, String>("observation"));

    points.setItems(observableList);
    points.refresh();
  }

  @Override
  public void onSelectedPoint() {
    Point selectedPoint = points.getSelectionModel().getSelectedItem();
    if (selectedPoint != null) {
      dateTextField.setText(selectedPoint.getDate());
      observationTextField.setText(selectedPoint.getObservation());
      addPointButton.setDisable(true);
      savePointButton.setDisable(false);
      deletePointButton.setDisable(false);
    }
  }

  @Override
  public void addPoint() {
    if (validateDate()) {
      addPointToTimeSheet();
      dateTextField.setText("");
      observationTextField.setText("");
    } else {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Dados invalidos");
      alert.setHeaderText("Preencha corretamente todos os campos");
      alert.setContentText("Nome, usuario e senha devem possuir mais de 3 caracteres.");
      alert.show();
    }
  }

  @Override
  public void savePoint() {
    Point selectedPoint = points.getSelectionModel().getSelectedItem();
    if (selectedPoint != null) {
      selectedPoint.setDate(dateTextField.getText());
      selectedPoint.setObservation(observationTextField.getText());
      dateTextField.setText("");
      observationTextField.setText("");
      points.getSelectionModel().clearSelection();
      showPointsTable();
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Sucesso!");
      alert.setHeaderText("Funcionário editado com sucesso!");
      alert.show();
    }
  }

  @Override
  public void deletePoint() {
    Point selectedPoint = points.getSelectionModel().getSelectedItem();
    if (selectedPoint != null) {
      LocalDeletePoint localDeletePoint = new LocalDeletePoint(timeSheet);
      localDeletePoint.deletePoint(selectedPoint.getId());
      dateTextField.setText("");
      observationTextField.setText("");
      points.getSelectionModel().clearSelection();
      showPointsTable();
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Sucesso!");
      alert.setHeaderText("Funcionário editado com sucesso!");
      alert.show();
    }
  }

  @Override
  public boolean validateDate() {
    if (dateTextField.getText().length() == 10) {
      return true;
    }
    return false;
  }

  @Override
  public void backPage() {
    backStage.show();
    stage.close();
  }
}
