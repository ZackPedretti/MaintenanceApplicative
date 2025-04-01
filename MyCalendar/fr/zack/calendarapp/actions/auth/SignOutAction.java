package fr.zack.calendarapp.actions.auth;

import fr.zack.calendarapp.actions.Action;
import fr.zack.calendarapp.ui.UI;
import fr.zack.calendarapp.user.AuthManager;

public class SignOutAction implements Action {

    AuthManager authManager;

    public SignOutAction(AuthManager authManager) {
        this.authManager = authManager;
    }

    @Override
    public void execute() {
        if (UI.askSignOut()) {
            authManager.signOut();
        }
        else{
            UI.printSignOutCanceled();
        }
    }
}
