package events;

public class EventWeek {
    int week;

    public EventWeek(int week) {
        if (week < 1 || week > 52) {
            throw new IllegalArgumentException("La semaine doit être entre 1 et 52.");
        }
        this.week = week;
    }

    public int getWeek() {
        return week;
    }
}
