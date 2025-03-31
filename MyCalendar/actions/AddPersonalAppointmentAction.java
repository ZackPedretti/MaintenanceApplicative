package actions;

import calendar.Calendar;
import events.EventDuration;
import events.EventTitle;
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
        EventTitle titre = new EventTitle(UI.askEventTitle());
        int year = UI.askYear();
        int month = UI.askMonth();
        int day = UI.askYear();
        int hour = UI.askBeginHour();
        int minute = UI.askBeginMinute();
        EventDuration duration = new EventDuration(UI.askDuration());

        calendar.addPersonalAppointment(titre, authManager.getSignedInUser(),
                LocalDateTime.of(year, month, day, hour, minute), duration);

        System.out.println("Événement ajouté.");
    }
}
