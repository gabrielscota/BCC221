import './entities.dart';

class TimeSheet {
  final String _id;
  List<Point> _points;

  TimeSheet(this._id) : _points = [];

  // Getter's
  String get id => this._id;
  List<Point> get points => this._points;

  // Setter's
  set points(List<Point> points) => this._points = points;
}
