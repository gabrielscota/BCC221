import './entities.dart';

class Orthodontist extends Employee {
  final String _id;
  Schedule _schedule;
  Assistent _assistent;

  Orthodontist(
    this._id,
  )   : _schedule = Schedule(_id),
        _assistent = Assistent(_id),
        super(_id);

  // Getter's
  String get id => this._id;
  Schedule get schedule => this._schedule;
  Assistent get assistent => this._assistent;

  // Setter's
  set schedule(Schedule schedule) => this._schedule = schedule;
  set assistent(Assistent assistent) => this._assistent = assistent;
}
