package data.usecases.time_sheet;

import domain.entities.Clinic;
import domain.entities.Point;
import domain.entities.TimeSheet;
import domain.usecases.time_sheet.AddPoint;

public class LocalAddPoint implements AddPoint {
  private final Clinic clinic;

  public LocalAddPoint(Clinic clinic) {
    this.clinic = clinic;
  }

  @Override
  public void addPoint(TimeSheet timeSheet, Point point) {
    if (timeSheet != null) {
      timeSheet.getPoints().add(point);
    }
  }
}
