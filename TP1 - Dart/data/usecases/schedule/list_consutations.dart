import '../../../domain/entities/entities.dart';
import '../../../domain/usecases/usecases.dart';

class MemoryListConsutations implements ListConsutations {
  @override
  void listConsutations(Schedule schedule) {
    schedule.consutations.forEach((consutation) {
      print(consutation);
    });
  }
}
