package fr.zack.calendarapp.actions.show_events;

import fr.zack.calendarapp.actions.Action;
import fr.zack.calendarapp.calendar.Calendar;
import fr.zack.calendarapp.ui.UI;

public class ShowAllEventsAction implements Action {
    Calendar calendar;

    public ShowAllEventsAction(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public void execute() {
        UI.printEvents(calendar.events);
    }
}
