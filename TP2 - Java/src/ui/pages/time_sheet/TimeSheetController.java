package ui.pages.time_sheet;

public interface TimeSheetController
{
  void backPage();
  void addPointToTimeSheet();
  void addPoint();
  void savePoint();
  void deletePoint();
  boolean validateDate();
  void showPointsTable();
  void onSelectedPoint();
}