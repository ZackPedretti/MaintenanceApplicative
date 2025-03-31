package actions.show_events;
import actions.Action;
import actions.BackAction;
import calendar.Calendar;
import ui.UI;
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

        Action[] actions = {(new ShowAllEventsAction(calendar)), (new ShowMonthEventsAction(calendar)), (new ShowWeekEventsAction(calendar)), (new ShowDayEventsAction(calendar)), (new BackAction())};

        try{
            actions[Integer.parseInt(scanner.nextLine())-1].execute();
        }
        catch(NumberFormatException | ArrayIndexOutOfBoundsException _) {
            UI.printIncorrectInput();
        }
    }
}
