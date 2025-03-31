package actions;

import calendar.Calendar;
import events.EventMonth;
import events.EventYear;
import ui.UI;

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
