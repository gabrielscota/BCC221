package domain.usecases.time_sheet;

import domain.entities.Point;
import domain.entities.TimeSheet;

public interface EditPoint {
  void editPoint(TimeSheet timeSheet, Point point);
}
