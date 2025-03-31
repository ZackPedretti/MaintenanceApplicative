package events;

public class EventDay {
    int day;

    public EventDay(int day) {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Le jour doit être entre 1 et 31.");
        }
        this.day = day;
    }

    public int getDay() {
        return day;
    }
}
