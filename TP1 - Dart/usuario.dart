import 'agenda/agenda.dart';
import 'pessoa.dart';

class Usuario extends Pessoa {
  final int _id;
  String _login;
  String _senha;

  Usuario(this._id, this._login, this._senha) : super(_id, '');

  // Getters
  int get id => this._id;
  String get login => this._login;
  String get senha => this._senha;

  // Setters
  set login(String login) => this._login = login;
  set senha(String senha) => this._senha = senha;
}

class UsuarioGeral with Agenda {
  final int _id;

  UsuarioGeral(this._id);

  // Getters
  int get id => this._id;

  @override
  void addConsulta(List<String> agenda, String consulta) {}

  @override
  void editarConsulta(int index, String consulta) {}

  @override
  void listarConsultas(List<String> agenda) {}
}

class UsuarioAssistenteAdministrativo implements Agenda {
  final int _id;

  UsuarioAssistenteAdministrativo(this._id);

  // Getters
  int get id => this._id;

  @override
  void addConsulta(List<String> agenda, String consulta) {}

  @override
  void editarConsulta(int index, String consulta) {}

  @override
  void listarConsultas(List<String> agenda) {}
}
