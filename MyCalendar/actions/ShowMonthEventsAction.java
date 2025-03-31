package actions;

import calendar.Calendar;
import ui.UI;

import java.time.LocalDateTime;

public class ShowMonthEventsAction implements Action {

    Calendar calendar;

    public ShowMonthEventsAction(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public void execute() {
        int year = UI.askYear();
        int month = UI.askMonth();

        LocalDateTime debutMois = LocalDateTime.of(year, month, 1, 0, 0);
        LocalDateTime finMois = debutMois.plusMonths(1).minusSeconds(1);

        UI.printEvents(calendar.eventsWithinPeriod(debutMois, finMois));
    }
}
