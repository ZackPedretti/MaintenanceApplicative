import java.time.LocalDateTime;

public class Periodic extends Event{
    PeriodicFrequency frequenceJours;
    public Periodic(EventTitle title, User proprietaire, LocalDateTime dateDebut, Duration dureeMinutes, PeriodicFrequency frequenceJours) {
        super(title, proprietaire, dateDebut, dureeMinutes);
        this.frequenceJours = frequenceJours;
    }

    public String description() {
        return "Événement périodique : " + title + " tous les " + frequenceJours + " jours";
    }

    public int getFrequenceJours() {
        return frequenceJours.getFrequency();
    }
}
