import java.time.LocalDateTime;

public class Periodic extends Event{
    int frequenceJours;
    public Periodic(EventTitle title, User proprietaire, LocalDateTime dateDebut, Duration dureeMinutes, int frequenceJours) {
        super(title, proprietaire, dateDebut, dureeMinutes);
        this.frequenceJours = frequenceJours;
    }

    public String description() {
        return "Événement périodique : " + title + " tous les " + frequenceJours + " jours";
    }

    public int getFrequenceJours() {
        return frequenceJours;
    }
}
