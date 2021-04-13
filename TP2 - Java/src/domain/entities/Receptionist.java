package domain.entities;

public class Receptionist extends Employee {
  public Receptionist(String id, String name, String login, String password, UserPermissions userPermissions) {
    super(id, name, login, password, userPermissions);
  }
}
