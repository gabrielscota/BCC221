package data.usecases.time_sheet;

import domain.entities.Clinic;
import domain.entities.Point;
import domain.entities.TimeSheet;
import domain.usecases.time_sheet.LoadPoints;

import java.util.List;

public class LocalLoadPoint implements LoadPoints {
  private final Clinic clinic;

  public LocalLoadPoint(Clinic clinic) {
    this.clinic = clinic;
  }

  @Override
  public List<Point> loadPoints(TimeSheet timeSheet) {
    if (timeSheet != null) {
      return timeSheet.getPoints();
    }
    return null;
  }
}
