package events;

import java.util.ArrayList;
import java.util.List;

public class Participants {
    List<String> participants;
    public Participants(String participantString) {
        participants = new ArrayList<>(List.of(participantString.split(",")));
    }

    @Override
    public String toString() {
        int size = participants.size();
        if (size == 0) return "";
        if (size == 1) return participants.get(0);
        if (size == 2) return participants.get(0) + " et " + participants.get(1);

        String lastParticipant = participants.remove(size - 1);
        return String.join(", ", participants) + " et " + lastParticipant;
    }
}
