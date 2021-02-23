import '../../../domain/entities/entities.dart';
import '../../../domain/usecases/usecases.dart';

class MemoryEditConsutation implements EditConsutation {
  @override
  void editConsutation(Schedule schedule, Consutation consutation) {
    schedule.consutations.forEach((cons) {
      if (cons.id == consutation.id) {
        cons = consutation;
      }
    });
  }
}
