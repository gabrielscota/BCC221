package domain.entities;

public class PaymentConsultation {
    private String id;
    private String patientName;
    private String paymentDate;
    private double value;

    public PaymentConsultation(String id, String patientName, String paymentDate, double value) {
        this.id = id;
        this.patientName = patientName;
        this.paymentDate = paymentDate;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
