package events;

import java.util.ArrayList;
import java.util.List;

public class Participants {
    List<String> participants;
    public Participants(String participantString) {
        participants = new ArrayList<String>(List.of(participantString.split(",")));
    }

    @Override
    public String toString() {
        return participants.toString();
    }
}
