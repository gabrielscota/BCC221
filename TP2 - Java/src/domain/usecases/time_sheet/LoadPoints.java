package domain.usecases.time_sheet;

import domain.entities.Point;
import domain.entities.TimeSheet;

import java.util.List;

public interface LoadPoints {
  List<Point> loadPoints(TimeSheet timeSheet);
}
