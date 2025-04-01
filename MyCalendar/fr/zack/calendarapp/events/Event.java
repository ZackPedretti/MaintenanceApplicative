package fr.zack.calendarapp.events;

import fr.zack.calendarapp.events.units.EventDuration;
import fr.zack.calendarapp.events.units.EventTitle;
import fr.zack.calendarapp.user.User;

import java.time.LocalDateTime;

public abstract class Event {
    public EventTitle title;
    public User owner;
    public LocalDateTime startingDate;
    public EventDuration eventDuration;


    public Event(EventTitle title, User owner, LocalDateTime startingDate, EventDuration duration) {
        this.title = title;
        this.owner = owner;
        this.startingDate = startingDate;
        this.eventDuration = duration;
    }

    public abstract String description();
}