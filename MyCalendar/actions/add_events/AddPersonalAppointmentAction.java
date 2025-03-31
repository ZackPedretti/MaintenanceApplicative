package actions.add_events;

import actions.Action;
import calendar.Calendar;
import events.*;
import ui.UI;
import user.AuthManager;

import java.time.LocalDateTime;

public class AddPersonalAppointmentAction implements Action {

    Calendar calendar;
    AuthManager authManager;

    public AddPersonalAppointmentAction(Calendar calendar, AuthManager authManager) {
        this.calendar = calendar;
        this.authManager = authManager;
    }

    @Override
    public void execute() {
        EventInfo eventInfo = UI.askPersonalAppointmentInfo();

        calendar.addPersonalAppointment(
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
