package presentation.controllers;

import domain.entities.Receptionist;
import domain.entities.UserPermissions;
import domain.usecases.receptionist.AddReceptionist;
import domain.usecases.receptionist.DeleteReceptionist;
import domain.usecases.receptionist.EditReceptionist;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import ui.pages.receptionist.ReceptionistController;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class PresentationReceptionistController implements ReceptionistController {
  private final AddReceptionist addReceptionist;
  private final EditReceptionist editReceptionist;
  private final DeleteReceptionist deleteReceptionist;

  private String name;

  @FXML
  TextField nameTextField = new TextField();

  public PresentationReceptionistController(AddReceptionist addReceptionist, EditReceptionist editReceptionist, DeleteReceptionist deleteReceptionist) {
    this.addReceptionist = addReceptionist;
    this.editReceptionist = editReceptionist;
    this.deleteReceptionist = deleteReceptionist;
  }

  @Override
  public void validateName() {
    if (nameTextField != null && nameTextField.getText().length() + 1 < 3) {
      System.out.println("Nome invalido!");
    } else {
      System.out.println("Nome: " + nameTextField.getText().substring(0, nameTextField.getText().length()));
      name = nameTextField.getText();
    }
  }

  @Override
  public void addReceptionist() {
    System.out.println("Nome: " + nameTextField.getText());
    UUID uuid = UUID.randomUUID();
    List<String> permissions = Arrays.asList("SCHEDULE");
    UserPermissions userPermissions = new UserPermissions(uuid.toString(), permissions);
    Receptionist receptionist = new Receptionist(uuid.toString(), name, name, "123456", userPermissions);
    addReceptionist.addReceptionist(receptionist);
  }
}
