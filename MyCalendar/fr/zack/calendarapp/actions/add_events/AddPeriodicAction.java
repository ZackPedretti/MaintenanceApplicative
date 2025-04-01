package fr.zack.calendarapp.actions.add_events;

import fr.zack.calendarapp.actions.Action;
import fr.zack.calendarapp.calendar.Calendar;
import fr.zack.calendarapp.events.EventInfo;
import fr.zack.calendarapp.events.units.EventDuration;
import fr.zack.calendarapp.ui.UI;
import fr.zack.calendarapp.user.AuthManager;

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
