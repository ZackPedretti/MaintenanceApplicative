package actions;

import calendar.Calendar;
import ui.UI;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Scanner;

public class ShowEventsAction implements Action {

    Calendar calendar;

    public ShowEventsAction(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        UI.printEventMenu();

        String choix = scanner.nextLine();

        switch (choix) {
            case "1": // Show all events
                (new ShowAllEventsAction(calendar)).execute();
                break;

            case "2": // Show events of a month
                (new ShowMonthEventsAction(calendar)).execute();
                break;

            case "3": // Show events of a week
                int anneeSemaine = UI.askYear();
                int semaine = UI.askWeek();

                LocalDateTime debutSemaine = LocalDateTime.now()
                        .withYear(anneeSemaine)
                        .with(WeekFields.of(Locale.FRANCE).weekOfYear(), semaine)
                        .with(WeekFields.of(Locale.FRANCE).dayOfWeek(), 1)
                        .withHour(0).withMinute(0);
                LocalDateTime finSemaine = debutSemaine.plusDays(7).minusSeconds(1);

                UI.printEvents(calendar.eventsWithinPeriod(debutSemaine, finSemaine));
                break;

            case "4": // Show events of a day
                int anneeJour = UI.askYear();
                int moisJour = UI.askMonth();
                int jour = UI.askDay();

                LocalDateTime debutJour = LocalDateTime.of(anneeJour, moisJour, jour, 0, 0);
                LocalDateTime finJour = debutJour.plusDays(1).minusSeconds(1);

                UI.printEvents(calendar.eventsWithinPeriod(debutJour, finJour));
                break;
        }
    }
}
