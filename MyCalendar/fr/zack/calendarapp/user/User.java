package fr.zack.calendarapp.user;

public class User {
    UserName name;
    UserPassword password;
    public User(String name, String password) {
        this.name = new UserName(name);
        this.password = new UserPassword(password);
    }

    public User(UserName name, UserPassword password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return name.toString();
    }

    public boolean hasName(UserName name) {
        return this.name.hasName(name.toString());
    }

    public boolean checkPassword(UserPassword password) {
        return this.password.checkPassword(password.toString());
    }
}
