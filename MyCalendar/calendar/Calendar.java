package calendar;

import events.*;
import user.User;

import java.time.LocalDateTime;

public class Calendar {
    public Events events;

    public Calendar() {
        this.events = new Events();
    }

    public void addMeeting(EventTitle title, User owner, LocalDateTime dateDebut, EventDuration dureeMinutes,
                           Place lieu, Participants participants){
        events.addEvent(new Meeting(title, owner, dateDebut, dureeMinutes, lieu, participants));
    }

    public void addPeriodic(EventTitle title, User proprietaire, LocalDateTime dateDebut, EventDuration dureeMinutes, PeriodicFrequency frequenceJours){
        events.addEvent(new Periodic(title, proprietaire, dateDebut, dureeMinutes, frequenceJours));
    }

    public void addPersonalAppointment(EventTitle title, User proprietaire, LocalDateTime dateDebut, EventDuration dureeMinutes){
        events.addEvent(new PersonalAppointment(title, proprietaire, dateDebut, dureeMinutes));
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
                    temp = temp.plusDays(((Periodic) e).getFrequenceJours());
                }
            } else if (!e.startingDate.isBefore(start) && !e.startingDate.isAfter(end)) {
                result.addEvent(e);
            }
        }
        return result;
    }

    public void showEvents() {
        for (Event e : events) {
            System.out.println(e.description());
        }
    }
}