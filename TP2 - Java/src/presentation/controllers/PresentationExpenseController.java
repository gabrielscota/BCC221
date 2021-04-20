package presentation.controllers;

import domain.entities.Expense;
import domain.usecases.expense.AddExpense;
import domain.usecases.expense.DeleteExpense;
import domain.usecases.expense.EditExpense;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import ui.pages.expense.ExpenseController;
import ui.pages.home.HomePage;
import javafx.scene.control.TextField;

import javax.xml.soap.Text;
import java.awt.*;
import java.util.UUID;

public class PresentationExpenseController implements ExpenseController {
  private final AddExpense addExpense;
  private final DeleteExpense deleteExpense;
  private final EditExpense editExpense;
  private final Stage stage;
  private final Stage backStage;

  @FXML
  TextField descriptionTextField = new TextField();
  @FXML
  TextField dueDateTextField = new TextField();
  @FXML
  TextField paymentDateTextField = new TextField();
  @FXML
  TextField valueTextField = new TextField();

  public PresentationExpenseController(AddExpense addExpense, DeleteExpense deleteExpense, EditExpense editExpense, Stage stage, Stage backStage) {
    this.addExpense = addExpense;
    this.deleteExpense = deleteExpense;
    this.editExpense = editExpense;
    this.stage = stage;
    this.backStage = backStage;
  }

  @Override
  public boolean validateDescription() {
    if (descriptionTextField != null && descriptionTextField.getText().length() + 1 < 6) {
      System.out.println("Descrição invalida!");
      return false;
    }
    return true;
  }

  @Override
  public boolean validatePaymentDate() {
    if (paymentDateTextField != null && paymentDateTextField.getText().length() != 10) {
      System.out.println("Data de pagamento invalida!");
      return false;
    }
    return true;
  }

  @Override
  public boolean validateDueDate() {
    if (dueDateTextField != null && dueDateTextField.getText().length() != 10) {
      System.out.println("Data de vencimento invalida!");
      return false;
    }
    return true;
  }

  @Override
  public boolean validateValue() {
    if (valueTextField == null) {
      System.out.println("Insira um valor!");
      return false;
    }
    return true;
  }

  @Override
  public void addExpense() {
    UUID uuid = UUID.randomUUID();
    Expense newExpense = new Expense(
            uuid.toString(),
            descriptionTextField.getText(),
            dueDateTextField.getText(),
            paymentDateTextField.getText(),
            Float.parseFloat(valueTextField.getText())
    );
    if (validateValue() && validateDescription() && validateDueDate() && validatePaymentDate()) {
      addExpense.addExpense(newExpense);
      System.out.println("Despesa cadastrada com sucesso!");
    }
  }

  @Override
  public void removeExpense() {

  }

  @Override
  public void editExpense() {

  }

  @Override
  public void backPage() {
    stage.close();
    backStage.show();
  }
}
