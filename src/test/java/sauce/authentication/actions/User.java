package sauce.authentication.actions;

public enum User {
    STANDARD_USER("standard_user", "secret_sauce", "A standard user"),
    LOCKED_OUT_USER("locked_out_user", "secret_sauce", "A user locked out of their account"),
    PROBLEM_USER("problem_user", "secret_sauce", "A user with a problem"),
    PERFORMANCE_GLITCH_USER("performance_glitch_user", "secret_sauce", "A user with performance issues");

    private final String userName;
    private final String password;
    private final String description;

    User(String userName, String password, String description){
        this.userName = userName;
        this.password = password;
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return description;
    }
}
