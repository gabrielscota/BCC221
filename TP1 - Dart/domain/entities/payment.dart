class Payment {
  final String _id;
  String _date;
  double _value;
  String _description;

  Payment(
    this._id, [
    this._date = '',
    this._value = 0.0,
    this._description = '',
  ]);

  // Getter's
  String get id => this._id;
  String get date => this._date;
  double get value => this._value;
  String get description => this._description;

  // Setter's
  set date(String date) => this._date = date;
  set value(double value) => this._value = value;
  set description(String description) => this._description = description;
}
