package actions;

import ui.UI;
import user.AuthManager;

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
