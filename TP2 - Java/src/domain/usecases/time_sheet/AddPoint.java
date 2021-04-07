package domain.usecases.time_sheet;

import domain.entities.Point;
import domain.entities.TimeSheet;

public interface AddPoint {
  void addPoint(TimeSheet timeSheet, Point point);
}
