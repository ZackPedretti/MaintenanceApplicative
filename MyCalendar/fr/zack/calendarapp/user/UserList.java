package fr.zack.calendarapp.user;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private static final List<User> USERS = new ArrayList<>(List.of(
            new User("Roger", "Chat"),
                new User("Pierre", "KiRouhl")
        ));

    public static List<User> getUsers() {
        return USERS;
    }
}
