package domain.entities;

import java.util.ArrayList;
import java.util.List;

public class TimeSheet {
  private final String id;
  private List<Point> points;

  public TimeSheet(String id, List<Point> points) {
    this.id = id;
    this.points = new ArrayList<Point>();
  }

  public String getId() {
    return id;
  }

  public List<Point> getPoints() {
    return points;
  }

  public void setPoints(List<Point> points) {
    this.points = points;
  }
}
