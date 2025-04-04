package fr.zack.calendarapp.ui;

import fr.zack.calendarapp.events.units.*;
import fr.zack.calendarapp.events.Event;
import fr.zack.calendarapp.events.EventInfo;
import fr.zack.calendarapp.events.Events;
import fr.zack.calendarapp.user.User;

import java.util.Scanner;

public class UI {

    private static final Scanner scanner = new Scanner(System.in);

    public static void printLoginMenu() {
        AsciiArt.printAscii();

        System.out.println("1 - Se connecter");
        System.out.println("2 - Créer un compte");
        System.out.println("Choix : ");
    }

    public static void printBaseMenu(User user) {
        System.out.println("\nBonjour, " + user);
        System.out.println("=== Menu Gestionnaire d'Événements ===");
        System.out.println("1 - Voir les événements");
        System.out.println("2 - Ajouter un rendez-vous perso");
        System.out.println("3 - Ajouter une réunion");
        System.out.println("4 - Ajouter un évènement périodique");
        System.out.println("5 - Ajouter une tâche");
        System.out.println("6 - Se déconnecter");
        System.out.print("Votre choix : ");
    }

    public static void printEventMenu() {
        System.out.println("\n=== Menu de visualisation d'Événements ===");
        System.out.println("1 - Afficher TOUS les événements");
        System.out.println("2 - Afficher les événements d'un MOIS précis");
        System.out.println("3 - Afficher les événements d'une SEMAINE précise");
        System.out.println("4 - Afficher les événements d'un JOUR précis");
        System.out.println("5 - Retour");
        System.out.print("Votre choix : ");
    }

    public static String askUserName() {
        System.out.print("Nom d'utilisateur: ");
        return scanner.nextLine();
    }

    public static String askUserPassword() {
        System.out.print("Mot de passe: ");
        return scanner.nextLine();
    }

    public static String askUserPasswordAgain() {
        System.out.print("Répéter mot de passe: ");
        return scanner.nextLine();
    }

    public static void printIncorrectPasswordRepetition() {
        System.out.println("Les mots de passes ne correspondent pas...");
    }

    public static void printNoEventFound() {
        System.out.println("Aucun événement trouvé pour cette période.");
    }

    public static void printFoundEvents(Events events) {
        for (Event e : events) {
            System.out.println("- " + e.description());
        }
    }

    public static void printEvents(Events events) {
        System.out.println("\n=== Évènements ===");
        if (events.isEmpty()) {
            printNoEventFound();
        } else {
            printFoundEvents(events);
        }
    }

    public static void printIncorrectInput() {
        System.out.println("Veuillez entrer un numéro correct.");
    }

    public static int askYear() {
        while (true) {
            System.out.print("Entrez l'année (AAAA) : ");
            String input = scanner.nextLine();
            if (input.matches("\\d{4}")) {
                return Integer.parseInt(input);
            }
            printIncorrectInput();
        }
    }

    public static int askMonth() {
        while (true) {
            System.out.print("Entrez le mois (1-12) : ");
            String input = scanner.nextLine();
            if (input.matches("^(0?[1-9]|1[0-2])$")) {
                return Integer.parseInt(input);
            }
            printIncorrectInput();
        }
    }

    public static int askWeek() {
        while (true) {
            System.out.print("Entrez le numéro de semaine (1-52) : ");
            String input = scanner.nextLine();
            if (input.matches("^(0?[1-9]|[1-4][0-9]|5[0-2])$")) {
                return Integer.parseInt(input);
            }
            printIncorrectInput();
        }
    }

    public static int askDay() {
        while (true) {
            System.out.print("Entrez le jour (1-31) : ");
            String input = scanner.nextLine();
            if (input.matches("^(0?[1-9]|[12][0-9]|3[01])$")) {
                return Integer.parseInt(input);
            }
            printIncorrectInput();
        }
    }

    public static int askStartHour() {
        while (true) {
            System.out.print("Heure début (0-23) : ");
            String input = scanner.nextLine();
            if (input.matches("^(0?[0-9]|1[0-9]|2[0-3])$")) {
                return Integer.parseInt(input);
            }
            printIncorrectInput();
        }
    }

    public static int askStartMinute() {
        while (true) {
            System.out.print("Minute début (0-59) : ");
            String input = scanner.nextLine();
            if (input.matches("^(0?[0-9]|[1-5][0-9])$")) {
                return Integer.parseInt(input);
            }
            printIncorrectInput();
        }
    }

    public static int askDuration() {
        while (true) {
            System.out.print("Durée (en minutes) : ");
            String input = scanner.nextLine();
            if (input.matches("^\\d+$") && Integer.parseInt(input) > 0) {
                return Integer.parseInt(input);
            }
            printIncorrectInput();
        }
    }

    public static String askEventTitle() {
        System.out.print("Titre de l'événement : ");
        return scanner.nextLine();
    }

    public static String askEventPlace() {
        System.out.println("Lieu :");
        return scanner.nextLine();
    }

    public static String askEventParticipants(StringBuilder participants) {
        System.out.println("Ajouter un participant ? (oui / non)");
        while (scanner.nextLine().equals("oui")) {
            System.out.print("events.Participants : " + participants);
            participants.append(", ").append(scanner.nextLine());
            System.out.println("Ajouter un participant ? (oui / non)");
        }
        return participants.toString();
    }

    public static EventInfo askEventInfo() {
        EventInfo eventInfo = new EventInfo();
        eventInfo.setEventTitle(new EventTitle(UI.askEventTitle()));
        eventInfo.setEventYear(new EventYear(UI.askYear()));
        eventInfo.setEventMonth(new EventMonth(UI.askMonth()));
        eventInfo.setEventDay(new EventDay(UI.askDay()));
        eventInfo.setEventStartHour(new EventStartHour(UI.askStartHour()));
        eventInfo.setEventStartMinute(new EventStartMinute(UI.askStartMinute()));

        return eventInfo;
    }

    public static EventInfo askPersonalAppointmentInfo() {
        EventInfo eventInfo = askEventInfo();
        eventInfo.setEventDuration(new EventDuration(UI.askDuration()));
        return eventInfo;
    }

    public static EventInfo askMeetingInfo() {
        EventInfo eventInfo = askEventInfo();
        eventInfo.setEventPlace(new Place(UI.askEventPlace()));
        eventInfo.setEventDuration(new EventDuration(UI.askDuration()));
        return eventInfo;
    }

    public static EventInfo askPeriodicInfo() {
        EventInfo eventInfo = askEventInfo();
        eventInfo.setPeriodicFrequency(new PeriodicFrequency(UI.askFrequency()));
        return eventInfo;
    }

    public static void printEventAdded() {
        System.out.println("Événement ajouté.");
    }

    public static int askFrequency() {
        while (true) {
            System.out.print("Fréquence (en jours) : ");
            String input = scanner.nextLine();
            if (input.matches("^\\d+$") && Integer.parseInt(input) > 0) {
                return Integer.parseInt(input);
            }
            printIncorrectInput();
        }
    }

    public static boolean askSignOut() {
        System.out.println("Déconnexion ! Voulez-vous continuer ? (Oui / Non)");
        return scanner.nextLine().trim().equalsIgnoreCase("oui");
    }

    public static void printSignOutCanceled() {
        System.out.println("Déconnexion annulée.");
    }
}
