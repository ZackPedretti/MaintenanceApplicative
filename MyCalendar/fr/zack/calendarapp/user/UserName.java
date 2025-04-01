package fr.zack.calendarapp.user;

public class UserName {
    String name;
    public UserName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean hasName(String name) {
        return this.name.equals(name);
    }
}
