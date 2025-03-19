import java.time.LocalDateTime;

public class Event {
    public EventType type;
    public EventTitle title;
    public User proprietaire;
    public LocalDateTime dateDebut;
    public Duration dureeMinutes;
    public String lieu; // utilisé seulement pour REUNION
    public String participants; // séparés par virgules (pour REUNION uniquement)
    public int frequenceJours; // uniquement pour PERIODIQUE


    public Event(EventType type, EventTitle title, User proprietaire, LocalDateTime dateDebut, Duration dureeMinutes,
                 String lieu, String participants, int frequenceJours) {
        this.type = type;
        this.title = title;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.dureeMinutes = dureeMinutes;
        this.lieu = lieu;
        this.participants = participants;
        this.frequenceJours = frequenceJours;
    }

    public String description() {
        String desc = "";
        if (type.equals(EventType.RDV_PERSONNEL)) {
            desc = "RDV : " + title + " à " + dateDebut.toString();
        } else if (type.equals(EventType.REUNION)) {
            desc = "Réunion : " + title + " à " + lieu + " avec " + participants;
        } else if (type.equals(EventType.PERIODIQUE)) {
            desc = "Événement périodique : " + title + " tous les " + frequenceJours + " jours";
        }
        return desc;
    }
}