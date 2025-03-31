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
        EventInfo eventInfo = UI.askPeriodicInfo();

        calendar.addPeriodic(
                eventInfo.getEventTitle(),
                authManager.getSignedInUser(),
                LocalDateTime.of(
                        eventInfo.getEventYear().getYear(),
                        eventInfo.getEventMonth().getMonth(),
                        eventInfo.getEventDay().getDay(),
                        eventInfo.getEventStartHour().getStartHour(),
                        eventInfo.getEventStartMinute().getStartMinute()
                ),
                new EventDuration(0),
                eventInfo.getPeriodicFrequency()
        );

        UI.printEventAdded();
    }
}
