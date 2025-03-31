package actions;
import ui.UI;
import user.*;
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
                actions[Integer.parseInt(scanner.nextLine())].execute();
            }
            catch(NumberFormatException | ArrayIndexOutOfBoundsException _) {
                UI.printIncorrectInput();
            }
        }
    }
}
