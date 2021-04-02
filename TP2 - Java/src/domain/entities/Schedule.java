package domain.entities;

public class Schedule {
    private String id;
    private Consultation consultations[];

    public Schedule(String id, Consultation[] consultations) {
        this.id = id;
        this.consultations = consultations;
    }

    public String getId() {
        return id;
    }

    public Consultation[] getConsultations() {
        return consultations;
    }

    public void setConsultations(Consultation[] consultations) {
        this.consultations = consultations;
    }
}
