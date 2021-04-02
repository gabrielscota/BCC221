package data.usecases.expense;

import domain.entities.Clinic;
import domain.entities.Expense;
import domain.usecases.expense.AddExpense;

public class LocalAddExpense implements AddExpense {
    private final Clinic clinic;

    public LocalAddExpense(Clinic clinic) {
        this.clinic = clinic;
    }

    @Override
    public void addExpense(Expense expense) {
        clinic.getExpenses().add(expense);
    }
}
