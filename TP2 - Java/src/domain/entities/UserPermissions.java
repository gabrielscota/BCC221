package domain.entities;

public class UserPermissions {
    private String id;
    private String permissions[];

    public UserPermissions(String id, String[] permissions) {
        this.id = id;
        this.permissions = permissions;
    }

    public String getId() {
        return id;
    }

    public String[] getPermissions() {
        return permissions;
    }

    public void setPermissions(String[] permissions) {
        this.permissions = permissions;
    }
}

class GeneralUser extends UserPermissions {
    public GeneralUser(String id, String[] permissions) {
        super(id, permissions);
    }
}

class AdministrativeAssistantUser extends UserPermissions {
    public AdministrativeAssistantUser(String id, String[] permissions) {
        super(id, permissions);
    }
}

class AdministrativeUser extends UserPermissions {
    public AdministrativeUser(String id, String[] permissions) {
        super(id, permissions);
    }
}
