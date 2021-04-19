package domain.entities;

public class Expense {
  private final String id;
  private String description;
  private String dueDate;
  private String paymentDate;
  private float value;

  public Expense(String id, String description, String dueDate, String paymentDate, float value) {
    this.id = id;
    this.description = description;
    this.dueDate = dueDate;
    this.paymentDate = paymentDate;
    this.value = value;
  }

  public String getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDueDate() {
    return dueDate;
  }

  public void setDueDate(String dueDate) {
    this.dueDate = dueDate;
  }

  public String getPaymentDate() {
    return paymentDate;
  }

  public void setPaymentDate(String paymentDate) {
    this.paymentDate = paymentDate;
  }

  public float getValue() {
    return value;
  }

  public void setValue(float value) {
    this.value = value;
  }
}
