import 'despesa/despesa.dart';
import 'ortodontista.dart';
import 'paciente/paciente.dart';
import 'recepcionista.dart';

class Clinica {
  final int id;
  final List<Ortodontista> ortodontistas;
  final List<Paciente> pacientes;
  final List<Despesa> despesas;
  final Recepcionista recepcionista;

  Clinica(
    this.id,
    this.ortodontistas,
    this.pacientes,
    this.despesas,
    this.recepcionista,
  );
}
