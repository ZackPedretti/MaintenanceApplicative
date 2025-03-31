package events;

import events.units.EventDuration;
import events.units.EventTitle;
import events.units.PeriodicFrequency;
import user.User;

import java.time.LocalDateTime;

public class Periodic extends Event {
    PeriodicFrequency frequency;
    public Periodic(EventTitle title, User owner, LocalDateTime startingDate, EventDuration duration, PeriodicFrequency frequency) {
        super(title, owner, startingDate, duration);
        this.frequency = frequency;
    }

    public String description() {
        return "Événement périodique : " + title + " tous les " + frequency + " jours";
    }

    public int getFrequency() {
        return frequency.getFrequency();
    }
}
