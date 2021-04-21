package data.usecases.time_sheet;

import domain.entities.Clinic;
import domain.entities.Point;
import domain.entities.TimeSheet;
import domain.usecases.time_sheet.AddPoint;

public class LocalAddPoint implements AddPoint {
  private final TimeSheet timeSheet;

  public LocalAddPoint(TimeSheet timeSheet) {
    this.timeSheet = timeSheet;
  }

  @Override
  public void addPoint(Point point) {
    if (timeSheet != null) {
      timeSheet.getPoints().add(point);
    }
  }
}
