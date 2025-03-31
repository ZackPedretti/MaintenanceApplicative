package events;

import events.units.EventDuration;
import events.units.EventTitle;
import user.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task extends Event{
    public Task(EventTitle title, User owner, LocalDateTime startingDate, EventDuration duration) {
        super(title, owner, startingDate, duration);
    }

    @Override
    public String description() {
        return "Tâche : " + title + " le " + startingDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
