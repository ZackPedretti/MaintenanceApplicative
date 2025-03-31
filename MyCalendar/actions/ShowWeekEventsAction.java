package actions;

import calendar.Calendar;
import events.EventWeek;
import events.EventYear;
import ui.UI;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class ShowWeekEventsAction implements Action {

    Calendar calendar;

    public ShowWeekEventsAction(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public void execute() {
        EventYear year = new EventYear(UI.askYear());
        EventWeek week = new EventWeek(UI.askWeek());

        LocalDateTime debutSemaine = LocalDateTime.now()
                .withYear(year.getYear())
                .with(WeekFields.of(Locale.FRANCE).weekOfYear(), week.getWeek())
                .with(WeekFields.of(Locale.FRANCE).dayOfWeek(), 1)
                .withHour(0).withMinute(0);
        LocalDateTime finSemaine = debutSemaine.plusDays(7).minusSeconds(1);

        UI.printEvents(calendar.eventsWithinPeriod(debutSemaine, finSemaine));
    }
}
