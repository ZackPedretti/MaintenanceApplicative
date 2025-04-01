package fr.zack.calendarapp.actions.auth;

import fr.zack.calendarapp.actions.Action;
import fr.zack.calendarapp.ui.UI;
import fr.zack.calendarapp.user.AuthManager;
import fr.zack.calendarapp.user.UserList;
import fr.zack.calendarapp.user.UserName;
import fr.zack.calendarapp.user.UserPassword;

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
