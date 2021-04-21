package domain.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class Orthodontist extends Employee {
  private Schedule schedule;
  private Assistent assistent;

  public Orthodontist(String id, String name, String login, String password, UserPermissions userPermissions) {
    super(id, name, login, password, userPermissions);
    this.schedule = new Schedule(UUID.randomUUID().toString(), new ArrayList<Consultation>());
  }

  public Schedule getSchedule() {
    return schedule;
  }

  public Assistent getAssistent() {
    return assistent;
  }

  public void setSchedule(Schedule schedule) {
    this.schedule = schedule;
  }

  public void setAssistent(Assistent assistent) {
    this.assistent = assistent;
  }
}
