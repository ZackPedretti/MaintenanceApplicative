package actions;

import calendar.Calendar;
import events.*;
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
        EventYear year = new EventYear(UI.askYear());
        EventMonth month = new EventMonth(UI.askMonth());
        EventDay day = new EventDay(UI.askYear());
        EventStartHour hour = new EventStartHour(UI.askStartHour());
        EventStartMinute minute = new EventStartMinute(UI.askStartMinute());
        PeriodicFrequency frequency = new PeriodicFrequency(UI.askFrequency());

        calendar.addPeriodic(title, authManager.getSignedInUser(),
                LocalDateTime.of(year.getYear(), month.getMonth(), day.getDay(), hour.getStartHour(), minute.getStartMinute()), new EventDuration(0),
                frequency);

        UI.printEventAdded();
    }
}
