package actions;

import calendar.Calendar;
import events.*;
import ui.UI;
import user.AuthManager;

import java.time.LocalDateTime;

public class AddMeetingAction implements Action {

    Calendar calendar;
    AuthManager authManager;

    public AddMeetingAction(Calendar calendar, AuthManager authManager) {
        this.calendar = calendar;
        this.authManager = authManager;
    }

    @Override
    public void execute() {
        EventInfo eventInfo = UI.askMeetingInfo();

        StringBuilder participants = new StringBuilder(authManager.getSignedInUser().toString());

        calendar.addMeeting(
                eventInfo.getEventTitle(),
                authManager.getSignedInUser(),
                LocalDateTime.of(
                        eventInfo.getEventYear().getYear(),
                        eventInfo.getEventMonth().getMonth(),
                        eventInfo.getEventDay().getDay(),
                        eventInfo.getEventStartHour().getStartHour(),
                        eventInfo.getEventStartMinute().getStartMinute()
                ),
                eventInfo.getEventDuration(),
                eventInfo.getEventPlace(),
                new Participants(UI.askEventParticipants(participants))
        );

        UI.printEventAdded();
    }
}
