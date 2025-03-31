package actions;

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
        EventTitle titre = new EventTitle(UI.askEventTitle());
        EventYear year = new EventYear(UI.askYear());
        EventMonth month = new EventMonth(UI.askMonth());
        EventDay day = new EventDay(UI.askYear());
        EventStartHour hour = new EventStartHour(UI.askStartHour());
        EventStartMinute minute = new EventStartMinute(UI.askStartMinute());
        EventDuration duration = new EventDuration(UI.askDuration());

        calendar.addPersonalAppointment(titre, authManager.getSignedInUser(),
                LocalDateTime.of(year.getYear(), month.getMonth(), day.getDay(), hour.getStartHour(), minute.getStartMinute()), duration);

        System.out.println("Événement ajouté.");
    }
}
