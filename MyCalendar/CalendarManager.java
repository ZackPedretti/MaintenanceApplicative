import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CalendarManager {
    public Events events;

    public CalendarManager() {
        this.events = new Events();
    }

    public void addMeeting(EventTitle title, User owner, LocalDateTime dateDebut, Duration dureeMinutes,
                           Place lieu, Participants participants){
        events.addEvent(new Meeting(title, owner, dateDebut, dureeMinutes, lieu, participants));
    }

    public void addPeriodic(EventTitle title, User proprietaire, LocalDateTime dateDebut, Duration dureeMinutes, PeriodicFrequency frequenceJours){
        events.addEvent(new Periodic(title, proprietaire, dateDebut, dureeMinutes, frequenceJours));
    }

    public void addPersonalAppointment(EventTitle title, User proprietaire, LocalDateTime dateDebut, Duration dureeMinutes){
        events.addEvent(new PersonalAppointment(title, proprietaire, dateDebut, dureeMinutes));
    }

    public List<Event> eventsWithinPeriod(LocalDateTime start, LocalDateTime end) {
        List<Event> result = new ArrayList<>();
        for (Event e : events) {
            if (e instanceof Periodic) {
                LocalDateTime temp = e.startingDate;
                while (temp.isBefore(end)) {
                    if (!temp.isBefore(start)) {
                        result.add(e);
                        break;
                    }
                    temp = temp.plusDays(((Periodic) e).getFrequenceJours());
                }
            } else if (!e.startingDate.isBefore(start) && !e.startingDate.isAfter(end)) {
                result.add(e);
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