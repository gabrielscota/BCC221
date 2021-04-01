package domain.entities;

public class TimeSheet {
    private String id;
    private Point points[];

    public TimeSheet(String id, Point[] points) {
        this.id = id;
        this.points = points;
    }

    public String getId() {
        return id;
    }

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }
}
