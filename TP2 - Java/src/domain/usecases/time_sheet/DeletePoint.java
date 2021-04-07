package domain.usecases.time_sheet;

import domain.entities.TimeSheet;

public interface DeletePoint {
  void deletePoint(TimeSheet timeSheet, String id);
}
