package data.usecases.expense;

import domain.entities.Clinic;
import domain.entities.Expense;
import domain.usecases.expense.EditExpense;

import java.util.List;

public class LocalEditExpense implements EditExpense {
  private final Clinic clinic;

  public LocalEditExpense(Clinic clinic) {
    this.clinic = clinic;
  }

  @Override
  public void editExpense(Expense expense) {
    List<Expense> expenses = clinic.getExpenses();
    if (!expenses.isEmpty()) {
      for (int i = 0; i < expenses.size(); i++) {
        if (expenses.get(i).getId() == expense.getId()) {
          expenses.set(i, expense);
          break;
        }
      }
    }
  }
}
