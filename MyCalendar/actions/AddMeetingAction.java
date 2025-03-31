package actions;

import calendar.Calendar;
import events.EventDuration;
import events.EventTitle;
import events.Participants;
import events.Place;
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
        EventTitle titre2 = new EventTitle(UI.askEventTitle());
        int year = UI.askYear();
        int month = UI.askMonth();
        int day = UI.askDay();
        int hour = UI.askBeginHour();
        int minute = UI.askBeginMinute();
        EventDuration duration = new EventDuration(UI.askDuration());

        Place lieu = new Place(UI.askEventPlace());

        StringBuilder participants = new StringBuilder(authManager.getSignedInUser().toString());

        calendar.addMeeting(titre2, authManager.getSignedInUser(),
                LocalDateTime.of(year, month, day, hour, minute), duration,
                lieu, new Participants(UI.askEventParticipants(participants)));

        UI.printEventAdded();
    }
}
