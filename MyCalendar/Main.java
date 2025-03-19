import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        CalendarManager calendar = new CalendarManager();
        Scanner scanner = new Scanner(System.in);
        User user = null;
        boolean continuer = true;

        List<User> users = new ArrayList<>(List.of(
                new User("Roger", "Chat"),
                new User("Pierre", "KiRouhl")
        ));

        String ascii = """
                   _____        _                   _                __  __
                 / ____|       | |                 | |              |  \\/  |
                | |       __ _ | |  ___  _ __    __| |  __ _  _ __  | \\  / |  __ _  _ __    __ _   __ _   ___  _ __
                | |      / _` || | / _ \\| '_ \\  / _` | / _` || '__| | |\\/| | / _` || '_ \\  / _` | / _` | / _ \\| '__|
                | |____ | (_| || ||  __/| | | || (_| || (_| || |    | |  | || (_| || | | || (_| || (_| ||  __/| |
                 \\_____| \\__,_||_| \\___||_| |_| \\__,_| \\__,_||_|    |_|  |_| \\__,_||_| |_| \\__,_| \\__, | \\___||_|
                                                                                                   __/ |
                                                                                                  |___/
                """;

        while (true) {

            if (user == null) {
                System.out.println(ascii);

                System.out.println("1 - Se connecter");
                System.out.println("2 - Créer un compte");
                System.out.println("Choix : ");

                switch (scanner.nextLine()) {

                    case "1":
                        user = signIn(scanner, users);
                        break;

                    case "2":

                        user = signUp(scanner);
                        if(user != null) users.add(user);
                        break;
                }
            }

            while (continuer && user != null) {
                System.out.println("\nBonjour, " + user);
                System.out.println("=== Menu Gestionnaire d'Événements ===");
                System.out.println("1 - Voir les événements");
                System.out.println("2 - Ajouter un rendez-vous perso");
                System.out.println("3 - Ajouter une réunion");
                System.out.println("4 - Ajouter un évènement périodique");
                System.out.println("5 - Se déconnecter");
                System.out.print("Votre choix : ");

                String choix = scanner.nextLine();

                switch (choix) {
                    case "1":
                        System.out.println("\n=== Menu de visualisation d'Événements ===");
                        System.out.println("1 - Afficher TOUS les événements");
                        System.out.println("2 - Afficher les événements d'un MOIS précis");
                        System.out.println("3 - Afficher les événements d'une SEMAINE précise");
                        System.out.println("4 - Afficher les événements d'un JOUR précis");
                        System.out.println("5 - Retour");
                        System.out.print("Votre choix : ");

                        choix = scanner.nextLine();

                        switch (choix) {
                            case "1":
                                calendar.afficherEvenements();
                                break;

                            case "2":
                                System.out.print("Entrez l'année (AAAA) : ");
                                int anneeMois = Integer.parseInt(scanner.nextLine());
                                System.out.print("Entrez le mois (1-12) : ");
                                int mois = Integer.parseInt(scanner.nextLine());

                                LocalDateTime debutMois = LocalDateTime.of(anneeMois, mois, 1, 0, 0);
                                LocalDateTime finMois = debutMois.plusMonths(1).minusSeconds(1);

                                afficherListe(calendar.eventsDansPeriode(debutMois, finMois));
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

                                afficherListe(calendar.eventsDansPeriode(debutSemaine, finSemaine));
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

                                afficherListe(calendar.eventsDansPeriode(debutJour, finJour));
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
                        String lieu = scanner.nextLine();

                        StringBuilder participants = new StringBuilder(user.toString());

                        System.out.println("Ajouter un participant ? (oui / non)");
                        while (scanner.nextLine().equals("oui")) {
                            System.out.print("Participants : " + participants);
                            participants.append(", ").append(scanner.nextLine());
                        }

                        calendar.addMeeting(titre2, user,
                                LocalDateTime.of(annee2, moisRdv2, jourRdv2, heure2, minute2), duree2,
                                lieu, participants.toString());

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
                        int frequence = Integer.parseInt(scanner.nextLine());

                        calendar.addPeriodic(titre3, user,
                                LocalDateTime.of(annee3, moisRdv3, jourRdv3, heure3, minute3), new Duration(0),
                                frequence);

                        System.out.println("Événement ajouté.");
                        break;

                    default:
                        System.out.println("Déconnexion ! Voulez-vous continuer ? (O/N)");
                        continuer = scanner.nextLine().trim().equalsIgnoreCase("oui");

                        user = null;
                }
            }
        }
    }

    private static void afficherListe(List<Event> evenements) {
        if (evenements.isEmpty()) {
            System.out.println("Aucun événement trouvé pour cette période.");
        } else {
            System.out.println("Événements trouvés : ");
            for (Event e : evenements) {
                System.out.println("- " + e.description());
            }
        }
    }

    private static User signIn(Scanner scanner, List<User> users) {
        System.out.print("Nom d'utilisateur: ");
        UserName userName = new UserName(scanner.nextLine());
        System.out.print("Mot de passe: ");
        UserPassword userPassword = new UserPassword(scanner.nextLine());
        System.out.println(users);
        return users.stream().filter(u -> u.hasName(userName) && u.checkPassword(userPassword)).findFirst().orElse(null);
    }

    private static User signUp(Scanner scanner) {
        System.out.print("Nom d'utilisateur: ");
        UserName userName = new UserName(scanner.nextLine());
        System.out.print("Mot de passe: ");
        UserPassword userPassword = new UserPassword(scanner.nextLine());
        System.out.print("Répéter mot de passe: ");
        UserPassword repeatedPassword = new UserPassword(scanner.nextLine());
        if(!repeatedPassword.checkPassword(userPassword.toString())) {
            System.out.println("Les mots de passes ne correspondent pas...");
            return null;
        }
        return new User(userName, userPassword);
    }
}
