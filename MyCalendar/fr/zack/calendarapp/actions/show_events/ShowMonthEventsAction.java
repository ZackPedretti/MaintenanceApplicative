package fr.zack.calendarapp.actions.show_events;

import fr.zack.calendarapp.actions.Action;
import fr.zack.calendarapp.calendar.Calendar;
import fr.zack.calendarapp.events.units.EventMonth;
import fr.zack.calendarapp.events.units.EventYear;
import fr.zack.calendarapp.ui.UI;

import java.time.LocalDateTime;

public class ShowMonthEventsAction implements Action {

    Calendar calendar;

    public ShowMonthEventsAction(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public void execute() {
        EventYear year = new EventYear(UI.askYear());
        EventMonth month = new EventMonth(UI.askMonth());

        LocalDateTime monthStart = LocalDateTime.of(year.getYear(), month.getMonth(), 1, 0, 0);
        LocalDateTime monthEnd = monthStart.plusMonths(1).minusSeconds(1);

        UI.printEvents(calendar.eventsWithinPeriod(monthStart, monthEnd));
    }
}
