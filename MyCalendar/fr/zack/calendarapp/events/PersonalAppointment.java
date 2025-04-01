package fr.zack.calendarapp.events;

import fr.zack.calendarapp.events.units.EventDuration;
import fr.zack.calendarapp.events.units.EventTitle;
import fr.zack.calendarapp.user.User;

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
