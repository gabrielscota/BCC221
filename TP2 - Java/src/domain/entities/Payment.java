package domain.entities;

public class Payment {
  private final String id;
  private String date;
  private double value;
  private String description;

  public Payment(String id, String date, double value, String description) {
    this.id = id;
    this.date = date;
    this.value = value;
    this.description = description;
  }

  public String getId() {
    return id;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public double getValue() {
    return value;
  }

  public void setValue(double value) {
    this.value = value;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
