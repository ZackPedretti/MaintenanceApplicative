import java.time.LocalDateTime;

public abstract class Event {
    public EventTitle title;
    public User proprietaire;
    public LocalDateTime dateDebut;
    public Duration dureeMinutes;


    public Event(EventTitle title, User proprietaire, LocalDateTime dateDebut, Duration dureeMinutes) {
        this.title = title;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.dureeMinutes = dureeMinutes;
    }

    abstract String description();
}