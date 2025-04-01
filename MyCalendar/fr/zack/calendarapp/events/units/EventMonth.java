package fr.zack.calendarapp.events.units;

public class EventMonth {
    int month;

    public EventMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Le mois doit être entre 1 et 12.");
        }
        this.month = month;
    }

    public int getMonth() {
        return month;
    }
}
