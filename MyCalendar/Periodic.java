import java.time.LocalDateTime;

public class Periodic extends Event{
    PeriodicFrequency frequenceJours;
    public Periodic(EventTitle title, User owner, LocalDateTime startingDate, Duration duration, PeriodicFrequency frequency) {
        super(title, owner, startingDate, duration);
        this.frequenceJours = frequency;
    }

    public String description() {
        return "Événement périodique : " + title + " tous les " + frequenceJours + " jours";
    }

    public int getFrequenceJours() {
        return frequenceJours.getFrequency();
    }
}
