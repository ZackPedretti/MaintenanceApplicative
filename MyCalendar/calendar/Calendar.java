package calendar;

import events.*;
import events.units.EventDuration;
import events.units.EventTitle;
import events.units.PeriodicFrequency;
import events.units.Place;
import user.User;

import java.time.LocalDateTime;

public class Calendar {
    public Events events;

    public Calendar() {
        this.events = new Events();
    }

    public void addMeeting(EventTitle title, User owner, LocalDateTime startDate, EventDuration duration,
                           Place lieu, Participants participants){
        events.addEvent(new Meeting(title, owner, startDate, duration, lieu, participants));
    }

    public void addPeriodic(EventTitle title, User owner, LocalDateTime startDate, EventDuration duration, PeriodicFrequency frequency){
        events.addEvent(new Periodic(title, owner, startDate, duration, frequency));
    }

    public void addPersonalAppointment(EventTitle title, User owner, LocalDateTime startDate, EventDuration duration){
        events.addEvent(new PersonalAppointment(title, owner, startDate, duration));
    }

    public void addTask(EventTitle title, User owner, LocalDateTime startDate, EventDuration duration){
        events.addEvent(new Task(title, owner, startDate, duration));
    }

    public Events eventsWithinPeriod(LocalDateTime start, LocalDateTime end) {
        Events result = new Events();
        for (Event e : events) {
            if (e instanceof Periodic) {
                LocalDateTime temp = e.startingDate;
                while (temp.isBefore(end)) {
                    if (!temp.isBefore(start)) {
                        result.addEvent(e);
                        break;
                    }
                    temp = temp.plusDays(((Periodic) e).getFrequency());
                }
            } else if (!e.startingDate.isBefore(start) && !e.startingDate.isAfter(end)) {
                result.addEvent(e);
            }
        }
        return result;
    }
}