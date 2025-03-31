import actions.menus.BaseMenuAction;
import actions.menus.SignInMenuAction;
import calendar.Calendar;
import user.AuthManager;

public class Main {
    public static void main(String[] args) {
        Calendar calendar = new Calendar();
        AuthManager authManager = new AuthManager();

        (new SignInMenuAction(authManager)).execute();

        (new BaseMenuAction(authManager, calendar)).execute();
    }
}
