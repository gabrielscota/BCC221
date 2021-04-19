package ui.pages.expense;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ExpensePage {
  private final ExpenseController expenseController;
  private Stage stage;
  public ExpensePage(ExpenseController expenseController){
    this.expenseController = expenseController;
  }
  public void build(Stage primaryStage) throws Exception{
    this.stage = primaryStage;
    FXMLLoader loader = new FXMLLoader(getClass().getResource("expense.fxml"));
    loader.setControllerFactory(c -> expenseController);
    Parent root = loader.load();
    primaryStage.setTitle("Despesas");
    primaryStage.setScene(new Scene(root));
    primaryStage.setResizable(false);
    primaryStage.show();
  }
}
