package presentation.controllers;

import data.usecases.authentication.LocalAuthentication;
import data.usecases.expense.LocalAddExpense;
import data.usecases.expense.LocalDeleteExpense;
import data.usecases.expense.LocalEditExpense;
import data.usecases.schedule.LocalAddConsultation;
import data.usecases.schedule.LocalLoadConsultations;
import domain.entities.Clinic;
import domain.entities.Consultation;
import domain.entities.Schedule;
import domain.usecases.schedule.LoadConsultations;
import javafx.stage.Stage;
import ui.pages.expense.ExpensePage;
import ui.pages.home.HomeController;
import ui.pages.login.LoginPage;
import javafx.fxml.FXML;
import java.util.List;

public class PresentationHomeController implements HomeController {
  final Clinic clinic;
  private Stage stage;

  public PresentationHomeController(Clinic clinic, Stage stage) {
    this.clinic = clinic;
    this.stage = stage;
  }

  void printTest(){
    System.out.println("Teste");
  }

  @Override
  public void logout() throws Exception{
    stage.close();
    LoginPage loginPage = new LoginPage(new PresentationLoginController(new LocalAuthentication(), new Stage()));
    loginPage.build(new Stage());
  }

  @Override
  public void loadSchedulesPage() throws Exception {

  };
  @Override
  public void loadConsultationPage() throws Exception {

  };
  @Override
  public void loadExpensesPage() throws Exception {
    Stage expenseStage = new Stage();
    ExpensePage expensePage = new ExpensePage(new PresentationExpenseController(
      new LocalAddExpense(clinic),
      new LocalDeleteExpense(clinic),
      new LocalEditExpense(clinic),
      expenseStage,
      stage
    ));
    expensePage.build(expenseStage);
    stage.close();
  };
  @Override
  public void loadTimeSheetPage() throws Exception {

  };
  @Override
  public void loadRelatoryPage() throws Exception {

  };
  @Override
  public void loadPayEmployeePage() throws Exception {

  };
  @Override
  public void loadManageEmployeePage() throws Exception {

  };
}
