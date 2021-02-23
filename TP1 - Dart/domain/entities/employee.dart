import './entities.dart';

class Employee extends User {
  final String _id;
  TimeSheet _timeSheet;
  List<Payment> _payments;

  Employee(this._id)
      : _timeSheet = TimeSheet(_id),
        _payments = [],
        super(_id);

  // Getter's
  String get id => this._id;
  TimeSheet get timeSheet => this._timeSheet;
  List<Payment> get payments => this._payments;

  // Setter's
  set timeSheet(TimeSheet timeSheet) => this._timeSheet = timeSheet;
  set payments(List<Payment> payments) => this._payments = payments;
}
