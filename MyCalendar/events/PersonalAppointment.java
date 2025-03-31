package events;

import user.User;

import java.time.LocalDateTime;

public class PersonalAppointment extends Event {
    public PersonalAppointment(EventTitle title, User owner, LocalDateTime startDate, EventDuration duration) {
        super(title, owner, startDate, duration);
    }

    public String description(){
        return "RDV : " + title + " à " + startingDate.toString();
    }
}
