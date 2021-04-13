package domain.entities;

import java.util.List;

public class UserPermissions {
    private final String id;
    private List<String> permissions;

    public UserPermissions(String id, List<String> permissions) {
        this.id = id;
        this.permissions = permissions;
    }

    public String getId() {
        return id;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
}

class GeneralUser extends UserPermissions {
    public GeneralUser(String id, List<String> permissions) {
        super(id, permissions);
    }
}

class AdministrativeAssistantUser extends UserPermissions {
    public AdministrativeAssistantUser(String id, List<String> permissions) {
        super(id, permissions);
    }
}

class AdministrativeUser extends UserPermissions {
    public AdministrativeUser(String id, List<String> permissions) {
        super(id, permissions);
    }
}
