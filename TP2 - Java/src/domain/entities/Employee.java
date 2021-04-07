package domain.entities;

public class Employee extends User {
  private String id;
  private TimeSheet timeSheet;
  private Payment payments[];

  public Employee(String id, String login, String password, UserPermissions userPermissions) {
    super(id, login, password, userPermissions);
  }

  public String getId() {
    return id;
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
