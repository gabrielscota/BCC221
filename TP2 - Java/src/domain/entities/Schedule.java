package domain.entities;

import java.util.List;

public class Schedule {
    private final String id;
    private List<Consultation> consultations;

    public Schedule(String id, List<Consultation> consultations) {
        this.id = id;
        this.consultations = consultations;
    }

    public String getId() {
        return id;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }
}
