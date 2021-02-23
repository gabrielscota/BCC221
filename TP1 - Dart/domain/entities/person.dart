class Person {
  final String _id;
  String _name;

  Person(this._id, [this._name = '']);

  // Getter's
  String get id => this._id;
  String get name => this._name;

  // Setter's
  set name(String name) => this._name = name;
}
