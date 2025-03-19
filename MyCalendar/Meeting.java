import java.time.LocalDateTime;

public class Meeting extends Event{
    String lieu;
    String participants;

    public Meeting(EventTitle title, User proprietaire, LocalDateTime dateDebut, Duration dureeMinutes, String lieu, String participants) {
        super(title, proprietaire, dateDebut, dureeMinutes);
        this.lieu = lieu;
        this.participants = participants;
    }

    public String description(){
        return "Réunion : " + title + " à " + lieu + " avec " + participants;
    }
}
