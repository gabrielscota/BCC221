package domain.entities;

public class Orthodontist extends Employee {
    private Schedule schedule;
    private Assistent assistent;

    public Orthodontist(String id, String login, String password, UserPermissions userPermissions) {
        super(id, login, password, userPermissions);
    }
    public Schedule getSchedule(){
        return schedule;
    }
    public Assistent getAssistent(){
        return assistent;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public void setAssistent(Assistent assistent) {
        this.assistent = assistent;
    }

}
