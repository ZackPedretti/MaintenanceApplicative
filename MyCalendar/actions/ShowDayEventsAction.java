package actions;

import calendar.Calendar;
import ui.UI;

import java.time.LocalDateTime;

public class ShowDayEventsAction implements Action {

    Calendar calendar;

    public ShowDayEventsAction(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public void execute() {
        int anneeJour = UI.askYear();
        int moisJour = UI.askMonth();
        int jour = UI.askDay();

        LocalDateTime debutJour = LocalDateTime.of(anneeJour, moisJour, jour, 0, 0);
        LocalDateTime finJour = debutJour.plusDays(1).minusSeconds(1);

        UI.printEvents(calendar.eventsWithinPeriod(debutJour, finJour));
    }
}
