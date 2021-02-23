import '../usecases/usecases.dart';

abstract class Agenda
    implements ListarConsultas, CadastrarConsulta, EditarConsulta {
  @override
  void addConsulta(List<String> agenda, String consulta);

  @override
  void editarConsulta(int index, String consulta);

  @override
  void listarConsultas(List<String> agenda);
}
