package events;

import events.units.*;

public class EventInfo {
    EventTitle eventTitle;
    EventYear eventYear;
    EventMonth eventMonth;
    EventDay eventDay;
    EventStartHour eventStartHour;
    EventStartMinute eventStartMinute;
    EventDuration eventDuration;
    PeriodicFrequency periodicFrequency;
    Place eventPlace;

    public void setEventTitle(EventTitle eventTitle) {
        this.eventTitle = eventTitle;
    }

    public void setEventYear(EventYear eventYear) {
        this.eventYear = eventYear;
    }

    public void setEventMonth(EventMonth eventMonth) {
        this.eventMonth = eventMonth;
    }

    public void setEventDay(EventDay eventDay) {
        this.eventDay = eventDay;
    }

    public void setEventStartHour(EventStartHour eventStartHour) {
        this.eventStartHour = eventStartHour;
    }

    public void setEventStartMinute(EventStartMinute eventStartMinute) {
        this.eventStartMinute = eventStartMinute;
    }

    public void setEventDuration(EventDuration eventDuration) {
        this.eventDuration = eventDuration;
    }

    public void setPeriodicFrequency(PeriodicFrequency periodicFrequency) {
        this.periodicFrequency = periodicFrequency;
    }

    public void setEventPlace(Place eventPlace) {
        this.eventPlace = eventPlace;
    }

    public EventTitle getEventTitle() {
        return eventTitle;
    }

    public EventYear getEventYear() {
        return eventYear;
    }

    public EventMonth getEventMonth() {
        return eventMonth;
    }

    public EventDay getEventDay() {
        return eventDay;
    }

    public EventStartHour getEventStartHour() {
        return eventStartHour;
    }

    public EventStartMinute getEventStartMinute() {
        return eventStartMinute;
    }

    public EventDuration getEventDuration() {
        return eventDuration;
    }

    public PeriodicFrequency getPeriodicFrequency() {
        return periodicFrequency;
    }

    public Place getEventPlace() {
        return eventPlace;
    }
}
