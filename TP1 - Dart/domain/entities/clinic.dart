import './entities.dart';

class Clinic {
  final String _id;
  List<Orthodontist> _orthodontists;
  List<Patient> _patients;
  List<Expense> _expenses;
  Receptionist _receptionist;

  Clinic(
    this._id,
    this._receptionist,
  )   : _orthodontists = [],
        _patients = [],
        _expenses = [];

  // Getter's
  String get id => this._id;
  List<Orthodontist> get orthodontists => this._orthodontists;
  List<Patient> get patients => this._patients;
  List<Expense> get expenses => this._expenses;
  Receptionist get receptionist => this._receptionist;

  // Setter's
  set orthodontists(List<Orthodontist> orthodontists) =>
      this._orthodontists = orthodontists;
  set patients(List<Patient> patients) => this._patients = patients;
  set expenses(List<Expense> expenses) => this._expenses = expenses;
  set receptionist(Receptionist receptionist) =>
      this._receptionist = receptionist;
}
