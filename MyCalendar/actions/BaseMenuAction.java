package actions;

import calendar.Calendar;
import ui.UI;
import user.AuthManager;

import java.util.Scanner;

public class BaseMenuAction implements Action {

    AuthManager authManager;
    Calendar calendar;

    public BaseMenuAction(AuthManager authManager, Calendar calendar) {
        this.calendar = calendar;
        this.authManager = authManager;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        Action[] actions = new Action[] {(new ShowEventsAction(calendar)), (new AddPersonalAppointmentAction(calendar, authManager)), (new AddMeetingAction(calendar, authManager)), (new AddPeriodicAction(calendar, authManager)), (new SignOutAction(authManager))};

        while (authManager.isSignedIn()) {
            UI.printBaseMenu(authManager.getSignedInUser());
            try{
                actions[Integer.parseInt(scanner.nextLine())-1].execute();
            }
            catch(NumberFormatException | ArrayIndexOutOfBoundsException _) {
                UI.printIncorrectInput();
            }
        }
    }
}
