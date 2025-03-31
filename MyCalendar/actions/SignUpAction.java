package actions;

import ui.UI;
import user.AuthManager;
import user.UserName;
import user.UserPassword;

import java.util.Scanner;

public class SignUpAction implements Action {

    AuthManager authManager;

    public SignUpAction(AuthManager authManager) {
        this.authManager = authManager;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        UserName userName = new UserName(UI.askUserName(scanner));
        UserPassword userPassword = new UserPassword(UI.askUserPassword(scanner));
        if (!userPassword.checkPassword(UI.askUserPasswordAgain(scanner))) {
            UI.printIncorrectPasswordRepetition();
        } else {
            authManager.signUp(userName, userPassword);
        }
    }
}
