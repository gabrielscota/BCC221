class PaymentConsutation {
  final String _id;
  double _value;

  PaymentConsutation(this._id, this._value);

  // Getter's
  String get id => this._id;
  double get value => this._value;

  // Setter's
  set value(double value) => this._value = value;
}
