import './entities.dart';

class Receptionist extends Employee {
  final String _id;

  Receptionist(this._id) : super(_id);

  // Getter's
  String get id => this._id;
}
