package events;

import user.User;

import java.time.LocalDateTime;

public class Meeting extends Event {
    Place place;
    Participants participants;

    public Meeting(EventTitle title, User owner, LocalDateTime startingDate, EventDuration duration, Place place, Participants participants) {
        super(title, owner, startingDate, duration);
        this.place = place;
        this.participants = participants;
    }

    public String description(){
        return "Réunion : " + title + " à " + place + " avec " + participants;
    }
}
