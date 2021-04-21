package data.usecases.time_sheet;

import domain.entities.Clinic;
import domain.entities.Point;
import domain.entities.TimeSheet;
import domain.usecases.time_sheet.DeletePoint;

import java.util.List;

public class LocalDeletePoint implements DeletePoint {
  private final TimeSheet timeSheet;

  public LocalDeletePoint(TimeSheet timeSheet) {
    this.timeSheet = timeSheet;
  }

  @Override
  public void deletePoint(String id) {
    List<Point> points = timeSheet.getPoints();
    if (!points.isEmpty()) {
      for (int i = 0; i < points.size(); i++) {
        if (points.get(i).getId() == id) {
          points.remove(i);
          break;
        }
      }
    }
  }
}
