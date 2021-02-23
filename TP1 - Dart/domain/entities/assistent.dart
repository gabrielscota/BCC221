import './entities.dart';

class Assistent extends Employee {
  final String _id;

  Assistent(this._id) : super(_id) {
    permissions = UserPermissions.administrativeAssistantUser(_id);
  }

  // Getter's
  String get id => this._id;
}
