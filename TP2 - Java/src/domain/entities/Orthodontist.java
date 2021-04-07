package domain.entities;

public class Orthodontist extends Employee {
  private Schedule schedule;
  private Assistent assistent;

  public Orthodontist(String id, String login, String password, UserPermissions userPermissions) {
    super(id, login, password, userPermissions);
  }
}
