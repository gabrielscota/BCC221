import './entities.dart';

class Patient extends Person {
  final String _id;

  Patient(this._id) : super(_id);

  // Getter's
  String get id => this._id;
}
