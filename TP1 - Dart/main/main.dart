import 'dart:io';

import '../domain/entities/entities.dart';

main() {
  Receptionist receptionist = Receptionist('0');
  receptionist.name = 'Luana';
  receptionist.login = 'luana';
  receptionist.password = '123';

  Clinic clinic = Clinic('0', receptionist);

  Assistent assistent = Assistent('0');
  assistent.name = 'Gabriel';
  assistent.login = 'gabriel';
  assistent.password = '123';

  Orthodontist orthodontist = Orthodontist('0');
  orthodontist.assistent = assistent;

  clinic.orthodontists.add(orthodontist);
  clinic.assistents.add(assistent);

  User loggedUser = User('');
  do {
    print('> Informe seu login: ');
    String? login = stdin.readLineSync();
    print('> Informe sua senha: ');
    String? password = stdin.readLineSync();

    if (clinic.admin.login == login && clinic.admin.password == password) {
      loggedUser = clinic.admin;
      break;
    } else if (clinic.receptionist.login == login &&
        clinic.receptionist.password == password) {
      loggedUser = receptionist;
      break;
    } else {
      for (var assistent in clinic.assistents) {
        if (assistent.login == login && assistent.password == password) {
          loggedUser = assistent;
          break;
        }
      }
      if (loggedUser.id != '') break;
    }

    print('\n[!] Login ou senha inválidos, tente novamente!\n');
  } while (loggedUser.id == '');

  for (var permission in loggedUser.permissions.permissions) {
    print(permission);
  }
}
