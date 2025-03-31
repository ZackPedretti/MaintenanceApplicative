package actions;

import ui.UI;
import user.AuthManager;
import user.UserList;
import user.UserName;
import user.UserPassword;

import java.util.Scanner;

public class SignInAction implements Action {

    AuthManager authManager;

    public SignInAction(AuthManager authManager) {
        this.authManager = authManager;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        UserName userName = new UserName(UI.askUserName());
        UserPassword userPassword = new UserPassword(UI.askUserPassword());
        System.out.println(UserList.getUsers());
        authManager.signIn(userName, userPassword);
    }
}
