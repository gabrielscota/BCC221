package domain.entities;

public class Assistent extends Employee {
  public Assistent(String id, String name, String login, String password, UserPermissions userPermissions) {
    super(id, name, login, password, userPermissions);
  }
}
