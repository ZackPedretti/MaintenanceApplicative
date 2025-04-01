package fr.zack.calendarapp.actions.show_events;

import fr.zack.calendarapp.actions.Action;
import fr.zack.calendarapp.calendar.Calendar;
import fr.zack.calendarapp.events.units.EventDay;
import fr.zack.calendarapp.events.units.EventMonth;
import fr.zack.calendarapp.events.units.EventYear;
import fr.zack.calendarapp.ui.UI;

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
