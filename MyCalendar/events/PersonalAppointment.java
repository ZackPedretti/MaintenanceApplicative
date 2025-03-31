package events;

import events.units.EventDuration;
import events.units.EventTitle;
import user.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PersonalAppointment extends Event {
    public PersonalAppointment(EventTitle title, User owner, LocalDateTime startDate, EventDuration duration) {
        super(title, owner, startDate, duration);
    }

    public String description(){
        return "RDV : " + title + " à " + startingDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
