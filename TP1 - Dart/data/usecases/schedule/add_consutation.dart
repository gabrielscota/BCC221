import '../../../domain/entities/entities.dart';
import '../../../domain/usecases/usecases.dart';

class MemoryAddConsutation implements AddConsutation {
  @override
  void addConsutation(Schedule schedule, Consutation consutation) {
    schedule.consutations.add(consutation);
  }
}
