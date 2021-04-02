package domain.entities;

public class Clinic {
    private final String id;
    private Orthodontist orthodontists[];
    private Assistent assistents[];
    private Patient patients[];
    private Expense expenses[];
    private PaymentConsultation payments[];
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

    public Expense[] getExpenses() {
        return expenses;
    }

    public void setExpenses(Expense[] expenses) {
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
