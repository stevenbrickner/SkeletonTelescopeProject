package Events.InternalEvents;

import java.time.Instant;
import Storage.ScheduledMission;

public class MissionEndEvent implements InternalEvent {

    private int priority;
    private Instant timestamp;

    private ScheduledMission mission;

    public MissionEndEvent(int priority, ScheduledMission mission) {
        this.priority = priority;
        this.timestamp = Instant.now();
        this.mission = mission;
    }

    public int getPriority() {
        return priority;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public ScheduledMission getMission() {
        return mission;
    }
}
