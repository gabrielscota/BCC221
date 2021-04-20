package presentation.controllers;

import domain.entities.Receptionist;
import domain.entities.UserPermissions;
import domain.usecases.receptionist.EditReceptionist;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ui.pages.receptionist.ReceptionistController;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class PresentationReceptionistController implements ReceptionistController {
  private final EditReceptionist editReceptionist;
  private String name;
  private Stage stage;
  private Stage backStage;

  @FXML
  TextField nameTextField = new TextField();
  @FXML
  Button saveButton = new Button();

  public PresentationReceptionistController(EditReceptionist editReceptionist, String name, Stage stage, Stage backStage) {
    this.editReceptionist = editReceptionist;
    this.name = name;
    this.stage = stage;
    this.backStage = backStage;
  }

  public void setRecepcionistName() {
    this.nameTextField.setText(this.name);
  }

  public void setSaveButtonStatus(boolean value) {
    this.saveButton.setDisable(value);
  }

  @Override
  public void validateName() {
    if (nameTextField != null && nameTextField.getText().length() < 3) {
      setSaveButtonStatus(true);
    } else {
      setSaveButtonStatus(false);
      name = nameTextField.getText();
    }
  }

  @Override
  public void addReceptionist() {
    UUID uuid = UUID.randomUUID();
    List<String> permissions = Arrays.asList("SCHEDULE");
    UserPermissions userPermissions = new UserPermissions(uuid.toString(), permissions);
    Receptionist receptionist = new Receptionist(uuid.toString(), name, name, "123456", userPermissions);
    editReceptionist.editReceptionist(receptionist);
  }

  @Override
  public void backPage() {
    stage.close();
    backStage.show();
  }
}
