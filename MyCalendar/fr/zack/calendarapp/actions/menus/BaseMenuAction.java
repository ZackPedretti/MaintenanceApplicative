package fr.zack.calendarapp.actions.menus;

import fr.zack.calendarapp.actions.Action;
import fr.zack.calendarapp.actions.add_events.AddTaskAction;
import fr.zack.calendarapp.actions.show_events.ShowEventsAction;
import fr.zack.calendarapp.actions.auth.SignOutAction;
import fr.zack.calendarapp.actions.add_events.AddMeetingAction;
import fr.zack.calendarapp.actions.add_events.AddPeriodicAction;
import fr.zack.calendarapp.actions.add_events.AddPersonalAppointmentAction;
import fr.zack.calendarapp.calendar.Calendar;
import fr.zack.calendarapp.ui.UI;
import fr.zack.calendarapp.user.AuthManager;

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

        Action[] actions = new Action[] {(new ShowEventsAction(calendar)), (new AddPersonalAppointmentAction(calendar, authManager)), (new AddMeetingAction(calendar, authManager)), (new AddPeriodicAction(calendar, authManager)), (new AddTaskAction(calendar, authManager)) , (new SignOutAction(authManager))};

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
