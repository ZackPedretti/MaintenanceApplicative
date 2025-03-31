package actions.auth;

import actions.Action;
import ui.UI;
import user.AuthManager;
import user.UserList;
import user.UserName;
import user.UserPassword;

public class SignInAction implements Action {

    AuthManager authManager;

    public SignInAction(AuthManager authManager) {
        this.authManager = authManager;
    }

    @Override
    public void execute() {
        UserName userName = new UserName(UI.askUserName());
        UserPassword userPassword = new UserPassword(UI.askUserPassword());
        System.out.println(UserList.getUsers());
        authManager.signIn(userName, userPassword);
    }
}
