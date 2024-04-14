package Events.InternalEvents;

import java.time.Instant;
import Storage.ScheduledMission;

public class MissionStartEvent implements InternalEvent {
    private int priority;
    private Instant timestamp; 

    private ScheduledMission mission;

    public MissionStartEvent(int priority, ScheduledMission mission) {
        this.priority = priority;
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
