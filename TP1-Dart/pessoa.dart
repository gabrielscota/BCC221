class Pessoa {
  final int _id;
  String _nome;

  Pessoa(this._id, this._nome);

  // Getters
  int get id => this._id;
  String get nome => this._nome;

  // Setters
  set nome(String nome) => this._nome = nome;
}
