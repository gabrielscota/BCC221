class UserPermissions {
  final String _id;
  List<String> _permissions;

  UserPermissions(this._id) : _permissions = [''];

  UserPermissions.generalUser(this._id) : _permissions = ['schedule'];

  UserPermissions.administrativeAssistantUser(this._id) : _permissions = ['schedule'];

  UserPermissions.administrativeUser(this._id) : _permissions = ['schedule'];

  // Getter's
  String get id => this._id;
  List<String> get permissions => this._permissions;

  // Setter's
  set permissions(List<String> permissions) => this._permissions = permissions;
}
