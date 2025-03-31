package actions.auth;

import actions.Action;
import ui.UI;
import user.AuthManager;
import user.UserName;
import user.UserPassword;

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
