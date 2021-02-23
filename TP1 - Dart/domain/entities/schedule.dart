import './entities.dart';

class Schedule {
  final String _id;
  List<Consutation> _consutations;

  Schedule(this._id) : _consutations = [];

  // Getter's
  String get id => this._id;
  List<Consutation> get consutations => this._consutations;

  // Setter's
  set consutations(List<Consutation> consutations) =>
      this._consutations = consutations;
}
