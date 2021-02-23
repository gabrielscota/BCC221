import 'assistente.dart';
import 'clinica.dart';
import 'ortodontista.dart';
import 'recepcionista.dart';

main() {
  // Criando a recepcionista da clinica (UsuarioGeral)
  Recepcionista recepcionista = Recepcionista(0);
  recepcionista.nome = 'Luana';
  recepcionista.login = 'lu';
  recepcionista.senha = '123';

  // Criando a clinica com seus dados inicialmente vazios e a recepcionista
  Clinica clinica = Clinica(0, [], [], [], recepcionista);

  // Assistente é um UsuarioAssistenteAdministrativo
  Assistente assistente = Assistente(0);
  assistente.nome = 'Sara';
  assistente.login = 'sara';
  assistente.senha = '1234';

  // Criando o ortodontista e a assistente do ortodontista
  Ortodontista ortodontista = Ortodontista(0, [], assistente);

  // Adicionando o ortodontista a clinica
  clinica.ortodontistas.add(ortodontista);

  // Recepcionista adicionando uma consulta
  recepcionista.addConsulta(
    ortodontista.agenda,
    'Consulta marcada pela recepcionista: ${recepcionista.nome}',
  );
  assistente.addConsulta(
    ortodontista.agenda,
    'Consulta marcada pela assistente: ${assistente.nome}',
  );

  // recepcionista.listarConsultas(ortodontista.agenda);
  assistente.listarConsultas(ortodontista.agenda);
}
