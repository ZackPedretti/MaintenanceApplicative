import calender.CalendarManager;
import events.*;
import ui.UI;
import user.AuthManager;
import user.User;
import user.UserList;
import events.Duration;
import actions.*;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        CalendarManager calendar = new CalendarManager();
        Scanner scanner = new Scanner(System.in);
        User user = null;
        boolean continuer = true;

        AuthManager authManager = new AuthManager();

        (new SignInMenuAction(authManager)).execute();

        while (continuer) {
            UI.printActionMenu(user);

            String choix = scanner.nextLine();

            switch (choix) {
                case "1":
                    UI.printEventMenu();

                    choix = scanner.nextLine();

                    switch (choix) {
                        case "1":
                            calendar.showEvents();
                            break;

                        case "2":
                            System.out.print("Entrez l'année (AAAA) : ");
                            int anneeMois = Integer.parseInt(scanner.nextLine());
                            System.out.print("Entrez le mois (1-12) : ");
                            int mois = Integer.parseInt(scanner.nextLine());

                            LocalDateTime debutMois = LocalDateTime.of(anneeMois, mois, 1, 0, 0);
                            LocalDateTime finMois = debutMois.plusMonths(1).minusSeconds(1);

                            afficherListe(calendar.eventsWithinPeriod(debutMois, finMois));
                            break;

                        case "3":
                            System.out.print("Entrez l'année (AAAA) : ");
                            int anneeSemaine = Integer.parseInt(scanner.nextLine());
                            System.out.print("Entrez le numéro de semaine (1-52) : ");
                            int semaine = Integer.parseInt(scanner.nextLine());

                            LocalDateTime debutSemaine = LocalDateTime.now()
                                    .withYear(anneeSemaine)
                                    .with(WeekFields.of(Locale.FRANCE).weekOfYear(), semaine)
                                    .with(WeekFields.of(Locale.FRANCE).dayOfWeek(), 1)
                                    .withHour(0).withMinute(0);
                            LocalDateTime finSemaine = debutSemaine.plusDays(7).minusSeconds(1);

                            afficherListe(calendar.eventsWithinPeriod(debutSemaine, finSemaine));
                            break;

                        case "4":
                            System.out.print("Entrez l'année (AAAA) : ");
                            int anneeJour = Integer.parseInt(scanner.nextLine());
                            System.out.print("Entrez le mois (1-12) : ");
                            int moisJour = Integer.parseInt(scanner.nextLine());
                            System.out.print("Entrez le jour (1-31) : ");
                            int jour = Integer.parseInt(scanner.nextLine());

                            LocalDateTime debutJour = LocalDateTime.of(anneeJour, moisJour, jour, 0, 0);
                            LocalDateTime finJour = debutJour.plusDays(1).minusSeconds(1);

                            afficherListe(calendar.eventsWithinPeriod(debutJour, finJour));
                            break;
                    }
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
                    Duration duree = new Duration(Integer.parseInt(scanner.nextLine()));

                    calendar.addPersonalAppointment(titre, user,
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
                    Duration duree2 = new Duration(Integer.parseInt(scanner.nextLine()));
                    System.out.println("Lieu :");
                    Place lieu = new Place(scanner.nextLine());

                    StringBuilder participants = new StringBuilder(user.toString());

                    System.out.println("Ajouter un participant ? (oui / non)");
                    while (scanner.nextLine().equals("oui")) {
                        System.out.print("events.Participants : " + participants);
                        participants.append(", ").append(scanner.nextLine());
                    }

                    calendar.addMeeting(titre2, user,
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
                    System.out.print("Frequence (en jours) : ");
                    PeriodicFrequency frequence = new PeriodicFrequency(Integer.parseInt(scanner.nextLine()));

                    calendar.addPeriodic(titre3, user,
                            LocalDateTime.of(annee3, moisRdv3, jourRdv3, heure3, minute3), new Duration(0),
                            frequence);

                    System.out.println("Événement ajouté.");
                    break;

                default:
                    System.out.println("Déconnexion ! Voulez-vous continuer ? (O/N)");
                    continuer = scanner.nextLine().trim().equalsIgnoreCase("oui");

                    authManager.signOut();
            }
        }
    }

    private static void afficherListe(Events events) {
        if (events.isEmpty()) {
            UI.printNoEventFound();
        } else {
            UI.printFoundEvents(events);
        }
    }
}
