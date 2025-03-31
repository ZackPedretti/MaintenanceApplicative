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
                    // Ajout simplifié d'un RDV personnel
                    System.out.print("Titre de l'événement : ");
                    EventTitle titre = new EventTitle(scanner.nextLine());
                    System.out.print("Année (AAAA) : ");
                    int annee = Integer.parseInt(scanner.nextLine());
                    System.out.print("Mois (1-12) : ");
                    int moisRdv = Integer.parseInt(scanner.nextLine());
                    System.out.print("Jour (1-31) : ");
                    int jourRdv = Integer.parseInt(scanner.nextLine());
                    System.out.print("Heure début (0-23) : ");
                    int heure = Integer.parseInt(scanner.nextLine());
                    System.out.print("Minute début (0-59) : ");
                    int minute = Integer.parseInt(scanner.nextLine());
                    System.out.print("Durée (en minutes) : ");
                    EventDuration duree = new EventDuration(Integer.parseInt(scanner.nextLine()));

                    calendar.addPersonalAppointment(titre, authManager.getSignedInUser(),
                            LocalDateTime.of(annee, moisRdv, jourRdv, heure, minute), duree);

                    System.out.println("Événement ajouté.");
                    break;

                case "3":
                    // Ajout simplifié d'une réunion
                    System.out.print("Titre de l'événement : ");
                    EventTitle titre2 = new EventTitle(scanner.nextLine());
                    System.out.print("Année (AAAA) : ");
                    int annee2 = Integer.parseInt(scanner.nextLine());
                    System.out.print("Mois (1-12) : ");
                    int moisRdv2 = Integer.parseInt(scanner.nextLine());
                    System.out.print("Jour (1-31) : ");
                    int jourRdv2 = Integer.parseInt(scanner.nextLine());
                    System.out.print("Heure début (0-23) : ");
                    int heure2 = Integer.parseInt(scanner.nextLine());
                    System.out.print("Minute début (0-59) : ");
                    int minute2 = Integer.parseInt(scanner.nextLine());
                    System.out.print("Durée (en minutes) : ");
                    EventDuration duree2 = new EventDuration(Integer.parseInt(scanner.nextLine()));
                    System.out.println("Lieu :");
                    Place lieu = new Place(scanner.nextLine());

                    StringBuilder participants = new StringBuilder(authManager.getSignedInUser().toString());

                    System.out.println("Ajouter un participant ? (oui / non)");
                    while (scanner.nextLine().equals("oui")) {
                        System.out.print("events.Participants : " + participants);
                        participants.append(", ").append(scanner.nextLine());
                    }

                    calendar.addMeeting(titre2, authManager.getSignedInUser(),
                            LocalDateTime.of(annee2, moisRdv2, jourRdv2, heure2, minute2), duree2,
                            lieu, new Participants(participants.toString()));

                    System.out.println("Événement ajouté.");
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
