package domain.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Clinic {
    private final String id;
    private Orthodontist[] orthodontists;
    private Assistent[] assistents;
    private Patient[] patients;
    private List<Expense> expenses;
    private PaymentConsultation[] payments;
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

    public Orthodontist[] getOrthodontists() {
        return orthodontists;
    }

    public void setOrthodontists(Orthodontist[] orthodontists) {
        this.orthodontists = orthodontists;
    }

    public void addOrthodontists(Orthodontist orthodontist){
        Orthodontist[] aux = this.getOrthodontists();
        ArrayList<Orthodontist> list = new ArrayList<Orthodontist>(Arrays.asList(aux));
        list.add(orthodontist);
        aux = list.toArray(aux);
        this.orthodontists = aux;
    }

    public Assistent[] getAssistents() {
        return assistents;
    }

    public void setAssistents(Assistent[] assistents) {
        this.assistents = assistents;
    }

    public Patient[] getPatients() {
        return patients;
    }

    public void setPatients(Patient[] patients) {
        this.patients = patients;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public PaymentConsultation[] getPayments() {
        return payments;
    }

    public void setPayments(PaymentConsultation[] payments) {
        this.payments = payments;
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
