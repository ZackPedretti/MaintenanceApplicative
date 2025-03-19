import java.time.LocalDateTime;

public class PersonalAppointment extends Event{
    public PersonalAppointment(EventTitle title, User proprietaire, LocalDateTime dateDebut, Duration dureeMinutes) {
        super(title, proprietaire, dateDebut, dureeMinutes);
    }

    public String description(){
        return "RDV : " + title + " à " + dateDebut.toString();
    }
}
