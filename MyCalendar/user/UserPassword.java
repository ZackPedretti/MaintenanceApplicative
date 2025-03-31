package user;

public class UserPassword {
    String password;
    public UserPassword(String password) {
        this.password = password;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    @Override
    public String toString() {
        return password;
    }
}
