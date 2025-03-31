package events.units;

public class EventStartHour {
    int startHour;

    public EventStartHour(int startHour) {
        if (startHour < 0 || startHour > 23) {
            throw new IllegalArgumentException("L'heure doit être entre 0 et 23.");
        }
        this.startHour = startHour;
    }

    public int getStartHour() {
        return startHour;
    }
}
