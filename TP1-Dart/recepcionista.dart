import 'funcionario/funcionario.dart';
import 'usuario.dart';

class Recepcionista extends Funcionario implements UsuarioGeral {
  final int _id;

  Recepcionista(this._id) : super(_id);

  // Getters
  int get id => this._id;

  @override
  void addConsulta(List<String> agenda, String consulta) {
    agenda.add(consulta);
  }

  @override
  void editarConsulta(int index, String consulta) {}

  @override
  void listarConsultas(List<String> agenda) {
    for (var consulta in agenda) {
      print(consulta);
    }
  }
}
