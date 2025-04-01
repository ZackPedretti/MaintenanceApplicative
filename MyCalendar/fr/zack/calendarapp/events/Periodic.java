package fr.zack.calendarapp.events;

import fr.zack.calendarapp.events.units.EventDuration;
import fr.zack.calendarapp.events.units.EventTitle;
import fr.zack.calendarapp.events.units.PeriodicFrequency;
import fr.zack.calendarapp.user.User;

import java.time.LocalDateTime;

public class Periodic extends Event {
    PeriodicFrequency frequency;

    public Periodic(EventTitle title, User owner, LocalDateTime startingDate, EventDuration duration, PeriodicFrequency frequency) {
        super(title, owner, startingDate, duration);
        this.frequency = frequency;
    }

    public String description() {
        return "Événement périodique : " + title + " tous les " + frequency.getFrequency() + " jours";
    }

    public int getFrequency() {
        return frequency.getFrequency();
    }
}
