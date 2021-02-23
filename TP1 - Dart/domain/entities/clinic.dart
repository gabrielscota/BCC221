import './entities.dart';

class Clinic {
  final String _id;
  List<Orthodontist> _orthodontists;
  List<Assistent> _assistents;
  List<Patient> _patients;
  List<Expense> _expenses;
  Receptionist _receptionist;
  Admin _admin;

  Clinic(
    this._id,
    this._receptionist,
  )   : _orthodontists = [],
        _assistents = [],
        _patients = [],
        _expenses = [],
        _admin = Admin(_id);

  // Getter's
  String get id => this._id;
  List<Orthodontist> get orthodontists => this._orthodontists;
  List<Assistent> get assistents => this._assistents;
  List<Patient> get patients => this._patients;
  List<Expense> get expenses => this._expenses;
  Receptionist get receptionist => this._receptionist;
  Admin get admin => this._admin;

  // Setter's
  set patients(List<Patient> patients) => this._patients = patients;
  set expenses(List<Expense> expenses) => this._expenses = expenses;
  set orthodontists(List<Orthodontist> orthodontists) =>
      this._orthodontists = orthodontists;
  set assistents(List<Assistent> assistents) => this._assistents = assistents;
  set receptionist(Receptionist receptionist) =>
      this._receptionist = receptionist;
}
