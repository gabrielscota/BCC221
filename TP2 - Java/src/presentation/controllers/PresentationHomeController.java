package presentation.controllers;

import data.usecases.authentication.LocalAuthentication;
import data.usecases.expense.LocalAddExpense;
import data.usecases.expense.LocalDeleteExpense;
import data.usecases.expense.LocalEditExpense;
import data.usecases.receptionist.LocalEditReceptionist;
import data.usecases.schedule.LocalAddConsultation;
import data.usecases.schedule.LocalLoadConsultations;
import domain.entities.*;
import domain.usecases.schedule.LoadConsultations;
import javafx.stage.Stage;
import ui.pages.employees.EmployeesPage;
import ui.pages.expense.ExpensePage;
import ui.pages.home.HomeController;
import ui.pages.login.LoginPage;
import javafx.fxml.FXML;
import ui.pages.payConsultations.PayConsultationController;
import ui.pages.payConsultations.PayConsultationPage;
import ui.pages.receptionist.ReceptionistPage;
import ui.pages.schedules.SchedulesPage;

import java.util.List;

public class PresentationHomeController implements HomeController {
  final Clinic clinic;
  private Stage stage;

  public PresentationHomeController(Clinic clinic, Stage stage) {
    this.clinic = clinic;
    this.stage = stage;
  }

  void printTest() {
    System.out.println("Teste");
  }

  @Override
  public void logout() throws Exception {
    stage.close();
    LoginPage loginPage = new LoginPage(new PresentationLoginController(new LocalAuthentication(), new Stage()));
    loginPage.build(new Stage());
  }

  @Override
  public void loadSchedulesPage() throws Exception {
    Stage schedulesStage = new Stage();
    SchedulesPage schedulesPage = new SchedulesPage(new PresentationSchedulesController(schedulesStage, stage, clinic));
    schedulesPage.build(schedulesStage);
    stage.close();
  }

  ;

  @Override
  public void loadConsultationPage() throws Exception {
    Stage consultationsStage = new Stage();
    PayConsultationPage payConsultationPage = new PayConsultationPage(new PresentationPayConsultationController(clinic, consultationsStage, stage));
    payConsultationPage.build(consultationsStage);
    stage.close();
  }

  ;

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
  }

  ;

  @Override
  public void loadReceptionistPage() throws Exception {
    Stage rececptionistStage = new Stage();
    ReceptionistPage receptionistPage = new ReceptionistPage(new PresentationReceptionistController(
            new LocalEditReceptionist(clinic),
            clinic.getReceptionist().getName(),
            rececptionistStage,
            stage
    ));
    receptionistPage.build(rececptionistStage);
    stage.close();
  }

  ;

  @Override
  public void loadTimeSheetPage() throws Exception {

  }

  ;

  @Override
  public void loadRelatoryPage() throws Exception {

  }

  ;

  @Override
  public void loadPayEmployeePage() throws Exception {

  }

  ;

  @Override
  public void loadManageEmployeePage() throws Exception {
    Stage employeeStage = new Stage();
    EmployeesPage employeePage = new EmployeesPage(new PresentationEmployeeController(
            employeeStage,
            stage,
            clinic
    ));
    employeePage.build(employeeStage);
    stage.close();
  }

  ;
}
