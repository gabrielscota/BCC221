package presentation.controllers;

import domain.usecases.expense.AddExpense;
import domain.usecases.expense.DeleteExpense;
import domain.usecases.expense.EditExpense;
import javafx.stage.Stage;
import ui.pages.expense.ExpenseController;

public class PresentationExpenseController implements ExpenseController {
    private final AddExpense addExpense;
    private final DeleteExpense deleteExpense;
    private final EditExpense editExpense;
    private final Stage stage;
    public PresentationExpenseController(AddExpense addExpense, DeleteExpense deleteExpense, EditExpense editExpense){
        this.addExpense = addExpense;
        this.deleteExpense = deleteExpense;
        this.editExpense = editExpense;
    }

    @Override
    public void validateDescription() {

    }

    @Override
    public void validatePaymentDate() {

    }

    @Override
    public void validateDueDate() {

    }

    @Override
    public void addExpense() {

    }

    @Override
    public void removeExpense() {

    }

    @Override
    public void editExpense() {

    }
    @Override
    public void backPage(){

    }
}
