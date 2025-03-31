package events;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Events implements Iterable<Event> {
    private List<Event> events;

    public Events() {
        events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    @Override
    public Iterator<Event> iterator() {
        return events.iterator();
    }

    public boolean isEmpty() {
        return events.isEmpty();
    }
}
