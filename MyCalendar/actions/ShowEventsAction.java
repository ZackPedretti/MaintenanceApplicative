package actions;

import calendar.Calendar;
import ui.UI;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Scanner;

public class ShowEventsAction implements Action{

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
            case "1":
                calendar.showEvents();
                break;

            case "2":
                int year = UI.askYear(scanner);
                int month = UI.askMonth(scanner);

                LocalDateTime debutMois = LocalDateTime.of(year, month, 1, 0, 0);
                LocalDateTime finMois = debutMois.plusMonths(1).minusSeconds(1);

                UI.printEvents(calendar.eventsWithinPeriod(debutMois, finMois));
                break;

            case "3":
                int anneeSemaine = UI.askYear(scanner);
                int semaine = UI.askWeek(scanner);

                LocalDateTime debutSemaine = LocalDateTime.now()
                        .withYear(anneeSemaine)
                        .with(WeekFields.of(Locale.FRANCE).weekOfYear(), semaine)
                        .with(WeekFields.of(Locale.FRANCE).dayOfWeek(), 1)
                        .withHour(0).withMinute(0);
                LocalDateTime finSemaine = debutSemaine.plusDays(7).minusSeconds(1);

                UI.printEvents(calendar.eventsWithinPeriod(debutSemaine, finSemaine));
                break;

            case "4":
                int anneeJour = UI.askYear(scanner);
                int moisJour = UI.askMonth(scanner);
                int jour = UI.askDay(scanner);

                LocalDateTime debutJour = LocalDateTime.of(anneeJour, moisJour, jour, 0, 0);
                LocalDateTime finJour = debutJour.plusDays(1).minusSeconds(1);

                UI.printEvents(calendar.eventsWithinPeriod(debutJour, finJour));
                break;
        }
    }
}
