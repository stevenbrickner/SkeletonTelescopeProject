package Events.Telecommunications.Telecommands;

import java.time.Instant;

import Storage.ScheduledMission;

public class AddMission implements Telecommand {
    private Instant timestamp;
    private int priority;
    private ScheduledMission mission;
    
    public AddMission(int priority, ScheduledMission mission) {
        this.timestamp = Instant.now();
        this.priority = priority;
        this.mission = mission;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
    public int getPriority() {
        return priority;
    }
    public ScheduledMission getMission() {
        return mission;
    }
}
