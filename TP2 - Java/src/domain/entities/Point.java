package domain.entities;

public class Point {
    private String id;
    private String date;
    private String observation;

    public Point(String id, String date, String observation) {
        this.id = id;
        this.date = date;
        this.observation = observation;
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

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
