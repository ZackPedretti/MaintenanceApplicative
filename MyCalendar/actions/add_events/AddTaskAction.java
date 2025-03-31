package actions.add_events;

import actions.Action;
import calendar.Calendar;
import events.EventInfo;
import ui.UI;
import user.AuthManager;

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
