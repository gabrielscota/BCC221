package domain.entities;

import java.util.Arrays;
import java.util.UUID;

public class Employee extends User {
  private TimeSheet timeSheet;
  private Payment payments[];

  public Employee(String id, String name, String login, String password, UserPermissions userPermissions) {
    super(id, name, login, password, userPermissions);
    this.timeSheet = new TimeSheet(UUID.randomUUID().toString(), Arrays.asList());
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
