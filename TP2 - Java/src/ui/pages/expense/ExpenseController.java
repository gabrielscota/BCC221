package ui.pages.expense;

public interface ExpenseController {
    void validateDescription();
    void validatePaymentDate();
    void validateDueDate();
    void addExpense();
    void removeExpense();
    void editExpense();
    void backPage();
}
