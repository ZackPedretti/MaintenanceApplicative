package actions;

import calendar.Calendar;

public class ShowAllEventsAction implements Action {
    Calendar calendar;

    public ShowAllEventsAction(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public void execute() {
        calendar.showEvents();
    }
}
