import fr.zack.calendarapp.actions.menus.BaseMenuAction;
import fr.zack.calendarapp.actions.menus.SignInMenuAction;
import fr.zack.calendarapp.calendar.Calendar;
import fr.zack.calendarapp.user.AuthManager;

public class Main {
    public static void main(String[] args) {
        Calendar calendar = new Calendar();
        AuthManager authManager = new AuthManager();

        (new SignInMenuAction(authManager)).execute();

        (new BaseMenuAction(authManager, calendar)).execute();
    }
}
