package domain.entities;

import java.util.List;

public class Clinic {
  private final String id;
  private List<Orthodontist> orthodontists;
  private List<Assistent> assistents;
  private List<Patient> patients;
  private List<Expense> expenses;
  private Receptionist receptionist;
  private User loggedUser;
  private Admin admin;

  public Clinic(String id, Receptionist receptionist, Admin admin) {
    this.id = id;
    this.receptionist = receptionist;
    this.admin = admin;
  }

  public String getId() {
    return id;
  }

  public List<Orthodontist> getOrthodontists() {
    return orthodontists;
  }

  public void setOrthodontists(List<Orthodontist> orthodontists) {
    this.orthodontists = orthodontists;
  }

  public List<Assistent> getAssistents() {
    return assistents;
  }

  public void setAssistents(List<Assistent> assistents) {
    this.assistents = assistents;
  }

  public List<Patient> getPatients() {
    return patients;
  }

  public void setPatients(List<Patient> patients) {
    this.patients = patients;
  }

  public List<Expense> getExpenses() {
    return expenses;
  }

  public void setExpenses(List<Expense> expenses) {
    this.expenses = expenses;
  }

  public Receptionist getReceptionist() {
    return receptionist;
  }

  public void setReceptionist(Receptionist receptionist) {
    this.receptionist = receptionist;
  }

  public User getLoggedUser() {
    return loggedUser;
  }

  public void setLoggedUser(User loggedUser) {
    this.loggedUser = loggedUser;
  }

  public Admin getAdmin() {
    return admin;
  }

  public void setAdmin(Admin admin) {
    this.admin = admin;
  }
}
