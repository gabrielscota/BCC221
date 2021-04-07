package data.usecases.expense;

import domain.entities.Clinic;
import domain.entities.Expense;
import domain.usecases.expense.DeleteExpense;

import java.util.List;

public class LocalDeleteExpense implements DeleteExpense {
  private final Clinic clinic;

  public LocalDeleteExpense(Clinic clinic) {
    this.clinic = clinic;
  }

  @Override
  public void deleteExpense(String id) {
    List<Expense> expenses = clinic.getExpenses();
    if (!expenses.isEmpty()) {
      for (int i = 0; i < expenses.size(); i++) {
        if (expenses.get(i).getId() == id) {
          expenses.remove(i);
          break;
        }
      }
    }
  }
}
