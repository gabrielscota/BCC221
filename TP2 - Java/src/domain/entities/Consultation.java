package domain.entities;

public class Consultation {
    private final String id;
    private Patient patient;
    private String date;
    private String description;
    private PaymentConsultation paymentConsultation;

    public Consultation(String id, Patient patient, String date, String description, PaymentConsultation paymentConsultation) {
        this.id = id;
        this.patient = patient;
        this.date = date;
        this.description = description;
        this.paymentConsultation = paymentConsultation;
    }

    public String getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PaymentConsultation getPaymentConsultation() {
        return paymentConsultation;
    }

    public void setPaymentConsultation(PaymentConsultation paymentConsultation) {
        this.paymentConsultation = paymentConsultation;
    }
}
