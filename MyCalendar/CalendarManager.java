import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CalendarManager {
    public List<Event> events;

    public CalendarManager() {
        this.events = new ArrayList<>();
    }

    public void addMeeting(EventTitle title, User proprietaire, LocalDateTime dateDebut, Duration dureeMinutes,
                           Place lieu, String participants){
        events.add(new Meeting(title, proprietaire, dateDebut, dureeMinutes, lieu, participants));
    }

    public void addPeriodic(EventTitle title, User proprietaire, LocalDateTime dateDebut, Duration dureeMinutes, PeriodicFrequency frequenceJours){
        events.add(new Periodic(title, proprietaire, dateDebut, dureeMinutes, frequenceJours));
    }

    public void addPersonalAppointment(EventTitle title, User proprietaire, LocalDateTime dateDebut, Duration dureeMinutes){
        events.add(new PersonalAppointment(title, proprietaire, dateDebut, dureeMinutes));
    }

    public List<Event> eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        List<Event> result = new ArrayList<>();
        for (Event e : events) {
            if (e instanceof Periodic) {
                LocalDateTime temp = e.startingDate;
                while (temp.isBefore(fin)) {
                    if (!temp.isBefore(debut)) {
                        result.add(e);
                        break;
                    }
                    temp = temp.plusDays(((Periodic) e).getFrequenceJours());
                }
            } else if (!e.startingDate.isBefore(debut) && !e.startingDate.isAfter(fin)) {
                result.add(e);
            }
        }
        return result;
    }

    public boolean conflit(Event e1, Event e2) {
        LocalDateTime fin1 = e1.startingDate.plusMinutes(e1.duration.getMinutes());
        LocalDateTime fin2 = e2.startingDate.plusMinutes(e2.duration.getMinutes());

        if (e1 instanceof Periodic || e2 instanceof Periodic) {
            return false; // Simplification abusive
        }

        return e1.startingDate.isBefore(fin2) && fin1.isAfter(e2.startingDate);
    }

    public void afficherEvenements() {
        for (Event e : events) {
            System.out.println(e.description());
        }
    }
}