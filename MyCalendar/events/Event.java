package events;

import user.User;

import java.time.LocalDateTime;

public abstract class Event {
    public EventTitle title;
    public User owner;
    public LocalDateTime startingDate;
    public Duration duration;


    public Event(EventTitle title, User owner, LocalDateTime startingDate, Duration duration) {
        this.title = title;
        this.owner = owner;
        this.startingDate = startingDate;
        this.duration = duration;
    }

    public abstract String description();
}