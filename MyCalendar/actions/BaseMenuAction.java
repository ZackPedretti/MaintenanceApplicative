package actions;

import calendar.Calendar;
import events.*;
import ui.UI;
import user.AuthManager;

import java.time.LocalDateTime;
import java.util.Scanner;

public class BaseMenuAction implements Action {

    AuthManager authManager;
    Calendar calendar;

    public BaseMenuAction(AuthManager authManager, Calendar calendar) {
        this.calendar = calendar;
        this.authManager = authManager;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        while (authManager.isSignedIn()) {
            UI.printBaseMenu(authManager.getSignedInUser());

            String choix = scanner.nextLine();

            switch (choix) {
                case "1":
                    (new ShowEventsAction(calendar)).execute();
                    break;

                case "2":
                    (new AddPersonalAppointmentAction(calendar, authManager)).execute();
                    break;

                case "3":
                    (new AddMeetingAction(calendar, authManager)).execute();
                    break;

                case "4":
                    // Ajout simplifié d'une réunion
                    System.out.print("Titre de l'événement : ");
                    EventTitle titre3 = new EventTitle(scanner.nextLine());
                    System.out.print("Année (AAAA) : ");
                    int annee3 = Integer.parseInt(scanner.nextLine());
                    System.out.print("Mois (1-12) : ");
                    int moisRdv3 = Integer.parseInt(scanner.nextLine());
                    System.out.print("Jour (1-31) : ");
                    int jourRdv3 = Integer.parseInt(scanner.nextLine());
                    System.out.print("Heure début (0-23) : ");
                    int heure3 = Integer.parseInt(scanner.nextLine());
                    System.out.print("Minute début (0-59) : ");
                    int minute3 = Integer.parseInt(scanner.nextLine());
                    System.out.print("Fréquence (en jours) : ");
                    PeriodicFrequency frequence = new PeriodicFrequency(Integer.parseInt(scanner.nextLine()));

                    calendar.addPeriodic(titre3, authManager.getSignedInUser(),
                            LocalDateTime.of(annee3, moisRdv3, jourRdv3, heure3, minute3), new EventDuration(0),
                            frequence);

                    System.out.println("Événement ajouté.");
                    break;

                default:
                    System.out.println("Déconnexion ! Voulez-vous continuer ? (O/N)");
                    if (scanner.nextLine().trim().equalsIgnoreCase("oui")) {
                        authManager.signOut();
                    }
                    else{
                        System.out.println("Déconnexion annulée.");
                    }
            }
        }
    }
}
