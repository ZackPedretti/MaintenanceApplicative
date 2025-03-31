package actions.show_events;

import actions.Action;
import calendar.Calendar;
import ui.UI;

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
