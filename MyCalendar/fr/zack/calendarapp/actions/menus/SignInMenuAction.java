package fr.zack.calendarapp.actions.menus;
import fr.zack.calendarapp.actions.Action;
import fr.zack.calendarapp.actions.auth.SignInAction;
import fr.zack.calendarapp.actions.auth.SignUpAction;
import fr.zack.calendarapp.ui.UI;
import fr.zack.calendarapp.user.AuthManager;
import java.util.Scanner;

public class SignInMenuAction implements Action {

    AuthManager authManager;

    public SignInMenuAction(AuthManager authManager) {
        this.authManager = authManager;
    }

    public void execute() {

        Action[] actions = {(new SignInAction(authManager)), (new SignUpAction(authManager))};

        Scanner scanner = new Scanner(System.in);
        while (!authManager.isSignedIn()) {

            UI.printLoginMenu();

            try{
                actions[Integer.parseInt(scanner.nextLine())-1].execute();
            }
            catch(NumberFormatException | ArrayIndexOutOfBoundsException _) {
                UI.printIncorrectInput();
            }
        }
    }
}
