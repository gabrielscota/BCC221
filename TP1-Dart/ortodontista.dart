import 'assistente.dart';
import 'funcionario/funcionario.dart';

class Ortodontista extends Funcionario {
  final int _id;
  List<String> _agenda;
  final Assistente _assistente;

  Ortodontista(this._id, this._agenda, this._assistente) : super(_id);

  // Getters
  int get id => this._id;
  List<String> get agenda => this._agenda;
  Assistente get assistente => this._assistente;

  // Setters
  set agenda(List<String> agenda) => this._agenda = agenda;
}
