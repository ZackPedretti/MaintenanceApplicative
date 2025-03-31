package actions;

import ui.UI;
import user.User;
import user.UserList;
import user.UserName;
import user.UserPassword;

import java.util.List;
import java.util.Scanner;

public class LogInUserAction implements Action{

    User user;

    public LogInUserAction(User user) {
        this.user = user;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        while (user == null) {

            UI.printBaseMenu();

            switch (scanner.nextLine()) {

                case "1":
                    user = signIn(scanner, UserList.getUsers());
                    break;

                case "2":

                    user = signUp(scanner);
                    if (user != null) UserList.getUsers().add(user);
                    break;
            }
        }
    }

    private static User signIn(Scanner scanner, List<User> users) {
        UserName userName = new UserName(UI.askUserName(scanner));
        UserPassword userPassword = new UserPassword(UI.askUserPassword(scanner));
        System.out.println(users);
        return users.stream().filter(u -> u.hasName(userName) && u.checkPassword(userPassword)).findFirst().orElse(null);
    }

    private static User signUp(Scanner scanner) {
        UserName userName = new UserName(UI.askUserName(scanner));
        UserPassword userPassword = new UserPassword(UI.askUserPassword(scanner));
        if (!userPassword.checkPassword(UI.askUserPassword(scanner))) {
            UI.printIncorrectPasswordRepetition();
            return null;
        }
        return new User(userName, userPassword);
    }
}
