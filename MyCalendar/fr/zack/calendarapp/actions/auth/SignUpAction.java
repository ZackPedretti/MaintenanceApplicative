package fr.zack.calendarapp.actions.auth;

import fr.zack.calendarapp.actions.Action;
import fr.zack.calendarapp.ui.UI;
import fr.zack.calendarapp.user.AuthManager;
import fr.zack.calendarapp.user.UserName;
import fr.zack.calendarapp.user.UserPassword;

public class SignUpAction implements Action {

    AuthManager authManager;

    public SignUpAction(AuthManager authManager) {
        this.authManager = authManager;
    }

    @Override
    public void execute() {
        UserName userName = new UserName(UI.askUserName());
        UserPassword userPassword = new UserPassword(UI.askUserPassword());
        if (!userPassword.checkPassword(UI.askUserPasswordAgain())) {
            UI.printIncorrectPasswordRepetition();
        } else {
            authManager.signUp(userName, userPassword);
        }
    }
}
