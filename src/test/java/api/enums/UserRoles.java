package api.enums;

public enum UserRoles {
    USER("app-user"),
    APP_MANAGER("app-manager"),
    ADMIN("app-admin"),
    PROJECT_MANAGER("project-manager"),
    PROJECT_MEMBER("project-member"),
    PROJECT_VIEWER("project-viewer");

    private String role;

    UserRoles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
