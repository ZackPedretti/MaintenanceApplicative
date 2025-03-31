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
        int annee = UI.askYear();
        int moisRdv = UI.askMonth();
        int jourRdv = UI.askYear();
        int heure = UI.askBeginHour();
        int minute = UI.askBeginMinute();
        EventDuration duree = new EventDuration(UI.askDuration());

        calendar.addPersonalAppointment(titre, authManager.getSignedInUser(),
                LocalDateTime.of(annee, moisRdv, jourRdv, heure, minute), duree);

        System.out.println("Événement ajouté.");
    }
}
