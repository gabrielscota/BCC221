package data.usecases.time_sheet;

import domain.entities.Clinic;
import domain.entities.Point;
import domain.entities.TimeSheet;
import domain.usecases.time_sheet.EditPoint;

import java.util.List;

public class LocalEditPoint implements EditPoint {
  private final Clinic clinic;

  public LocalEditPoint(Clinic clinic) {
    this.clinic = clinic;
  }

  @Override
  public void editPoint(TimeSheet timeSheet, Point point) {
    List<Point> points = timeSheet.getPoints();
    if (!points.isEmpty()) {
      for (int i = 0; i < points.size(); i++) {
        if (points.get(i).getId() == point.getId()) {
          points.set(i, point);
          break;
        }
      }
    }
  }
}
