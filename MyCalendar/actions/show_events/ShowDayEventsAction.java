package actions.show_events;

import actions.Action;
import calendar.Calendar;
import events.units.EventDay;
import events.units.EventMonth;
import events.units.EventYear;
import ui.UI;

import java.time.LocalDateTime;

public class ShowDayEventsAction implements Action {

    Calendar calendar;

    public ShowDayEventsAction(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public void execute() {
        EventYear year = new EventYear(UI.askYear());
        EventMonth month = new EventMonth(UI.askMonth());
        EventDay day = new EventDay(UI.askDay());

        LocalDateTime dayStart = LocalDateTime.of(year.getYear(), month.getMonth(), day.getDay(), 0, 0);
        LocalDateTime dayEnd = dayStart.plusDays(1).minusSeconds(1);

        UI.printEvents(calendar.eventsWithinPeriod(dayStart, dayEnd));
    }
}
