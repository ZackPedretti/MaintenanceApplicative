package actions;

import calendar.Calendar;
import events.EventDuration;
import events.EventTitle;
import events.PeriodicFrequency;
import ui.UI;
import user.AuthManager;

import java.time.LocalDateTime;

public class AddPeriodicAction implements Action {

    Calendar calendar;
    AuthManager authManager;

    public AddPeriodicAction(Calendar calendar, AuthManager authManager) {
        this.calendar = calendar;
        this.authManager = authManager;
    }

    @Override
    public void execute() {
        EventTitle title = new EventTitle(UI.askEventTitle());
        int year = UI.askYear();
        int month = UI.askMonth();
        int day = UI.askDay();
        int hour = UI.askBeginHour();
        int minute = UI.askBeginMinute();
        PeriodicFrequency frequency = new PeriodicFrequency(UI.askFrequency());

        calendar.addPeriodic(title, authManager.getSignedInUser(),
                LocalDateTime.of(year, month, day, hour, minute), new EventDuration(0),
                frequency);

        UI.printEventAdded();
    }
}
