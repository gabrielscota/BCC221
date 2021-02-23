import './entities.dart';

class Admin extends User {
  final String _id;

  Admin(this._id) : super(_id) {
    login = 'admin';
    password = 'admin';
    permissions = UserPermissions.administrativeUser(_id);
  }
}
