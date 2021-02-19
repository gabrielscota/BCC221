import '../pagamento/pagamento.dart';
import '../usuario.dart';

class Funcionario extends Usuario {
  final int _id;
  List<Pagamento> _pagamentos = [];

  Funcionario(this._id) : super(_id, '', '');

  // Getters
  int get id => this._id;
  List<Pagamento> get pagamentos => this._pagamentos;
}
