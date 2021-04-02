package domain.entities;

public class Receptionist extends Employee {
    public Receptionist(String id, String login, String password, UserPermissions userPermissions) {
        super(id, login, password, userPermissions);
    }
}
