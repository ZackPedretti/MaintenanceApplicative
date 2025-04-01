import fr.zack.calendarapp.calendar.Calendar;
import fr.zack.calendarapp.events.*;
import fr.zack.calendarapp.events.units.*;
import fr.zack.calendarapp.user.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

public class TestsShowEventsWithinPeriod {
    @Test
    public void testShowMeetingWithinPeriod() {
        Calendar calendar = new Calendar();
        User owner = new User("Alice", "password");
        EventTitle title = new EventTitle("Team Meeting");
        LocalDateTime start = LocalDateTime.of(2025, 4, 10, 10, 0);
        EventDuration duration = new EventDuration(60);
        Place place = new Place("Conference Room");
        Participants participants = new Participants("");

        calendar.addMeeting(title, owner, start, duration, place, participants);

        Events events = calendar.eventsWithinPeriod(
                LocalDateTime.of(2025, 4, 9, 0, 0),
                LocalDateTime.of(2025, 4, 11, 0, 0)
        );

        assertEquals(1, events.size());
    }

    @Test
    public void testShowPeriodicWithinPeriod() {
        Calendar calendar = new Calendar();
        User owner = new User("Bob", "password");
        EventTitle title = new EventTitle("Daily Standup");
        LocalDateTime start = LocalDateTime.of(2025, 4, 1, 9, 0);
        EventDuration duration = new EventDuration(30);
        PeriodicFrequency frequency = new PeriodicFrequency(1); // Every day

        calendar.addPeriodic(title, owner, start, duration, frequency);

        Events events = calendar.eventsWithinPeriod(
                LocalDateTime.of(2025, 4, 3, 0, 0),
                LocalDateTime.of(2025, 4, 5, 0, 0)
        );

        assertEquals(2, events.size()); // Expect two occurrences
    }

    @Test
    public void testShowPersonalAppointmentWithinPeriod() {
        Calendar calendar = new Calendar();
        User owner = new User("Charlie", "password");
        EventTitle title = new EventTitle("Doctor Appointment");
        LocalDateTime start = LocalDateTime.of(2025, 4, 15, 14, 0);
        EventDuration duration = new EventDuration(45);

        calendar.addPersonalAppointment(title, owner, start, duration);

        Events events = calendar.eventsWithinPeriod(
                LocalDateTime.of(2025, 4, 14, 0, 0),
                LocalDateTime.of(2025, 4, 16, 0, 0)
        );

        assertEquals(1, events.size());
    }
}
