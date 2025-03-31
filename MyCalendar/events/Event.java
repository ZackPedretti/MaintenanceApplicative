package events;

import events.units.EventDuration;
import events.units.EventTitle;
import user.User;

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