package ui.pages.expense;

public interface ExpenseController {
    boolean validateDescription();
    boolean validatePaymentDate();
    boolean validateDueDate();
    boolean validateValue();
    void addExpense();
    void removeExpense();
    void editExpense();
    void backPage();
}
