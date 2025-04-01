package fr.zack.calendarapp.actions.add_events;

import fr.zack.calendarapp.actions.Action;
import fr.zack.calendarapp.calendar.Calendar;
import fr.zack.calendarapp.events.EventInfo;
import fr.zack.calendarapp.ui.UI;
import fr.zack.calendarapp.user.AuthManager;

import java.time.LocalDateTime;

public class AddTaskAction implements Action {

    Calendar calendar;
    AuthManager authManager;

    public AddTaskAction(Calendar calendar, AuthManager authManager) {
        this.calendar = calendar;
        this.authManager = authManager;
    }

    @Override
    public void execute() {
        EventInfo eventInfo = UI.askPersonalAppointmentInfo();

        calendar.addTask(
                eventInfo.getEventTitle(),
                authManager.getSignedInUser(),
                LocalDateTime.of(
                        eventInfo.getEventYear().getYear(),
                        eventInfo.getEventMonth().getMonth(),
                        eventInfo.getEventDay().getDay(),
                        eventInfo.getEventStartHour().getStartHour(),
                        eventInfo.getEventStartMinute().getStartMinute()
                ),
                eventInfo.getEventDuration()
        );

        UI.printEventAdded();
    }
}
