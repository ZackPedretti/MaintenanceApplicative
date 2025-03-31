package events;

public class EventStartMinute {
    int startMinute;

    public EventStartMinute(int startMinute) {
        if (startMinute < 0 || startMinute > 59) {
            throw new IllegalArgumentException("La minute doit être entre 0 et 59.");
        }
        this.startMinute = startMinute;
    }

    public int getStartMinute() {
        return startMinute;
    }
}
