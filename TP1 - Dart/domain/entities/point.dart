class Point {
  final String _id;
  String _date;
  String _observation;

  Point(this._id, [this._date = '', this._observation = '']);

  // Getter's
  String get id => this._id;
  String get date => this._date;
  String get observation => this._observation;

  // Setter's
  set date(String date) => this._date = date;
  set observation(String observation) => this._observation = observation;
}
