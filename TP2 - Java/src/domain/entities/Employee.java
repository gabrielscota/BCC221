package domain.entities;

public class Employee extends User {
  private TimeSheet timeSheet;
  private Payment payments[];

  public Employee(String id, String name, String login, String password, UserPermissions userPermissions) {
    super(id, name, login, password, userPermissions);
  }

  public TimeSheet getTimeSheet() {
    return timeSheet;
  }

  public void setTimeSheet(TimeSheet timeSheet) {
    this.timeSheet = timeSheet;
  }

  public Payment[] getPayments() {
    return payments;
  }

  public void setPayments(Payment[] payments) {
    this.payments = payments;
  }
}
