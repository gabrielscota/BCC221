import './entities.dart';

class Consutation {
  final String _id;
  Patient _patient;
  String _date;
  String _description;
  PaymentConsutation _paymentConsutation;

  Consutation(
    this._id,
    this._patient,
    this._date,
    this._description,
    this._paymentConsutation,
  );

  // Getter's
  String get id => this._id;
  Patient get patient => this._patient;
  String get date => this._date;
  String get description => this._description;
  PaymentConsutation get paymentConsutation => this._paymentConsutation;

  // Setter's
  set patient(Patient patient) => this._patient = patient;
  set date(String date) => this._date = date;
  set description(String description) => this._description = description;
  set paymentConsutation(PaymentConsutation paymentConsutation) =>
      this._paymentConsutation = paymentConsutation;
}
