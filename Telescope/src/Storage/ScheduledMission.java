package Storage;

import java.io.Serializable;
import java.time.Instant;

public class ScheduledMission implements Comparable<ScheduledMission>, Serializable {
    private int missionID;
    private String missionName;
    private String celestialObjectName;
    private Instant startTime;
    private Instant endTime;

    public ScheduledMission (int missionID, String missionName, String celestialObjectName, Instant startTime, Instant endTime) {
        this.missionID = missionID;
        this.missionName = missionName;
        this.celestialObjectName = celestialObjectName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getID() {
        return missionID;
    }

    public void setMissionID(int missionID) {
        this.missionID = missionID;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public String getCelestialObjectName() {
        return celestialObjectName;
    }

    public void setCelestialObjectName(String celestialObjectName) {
        this.celestialObjectName = celestialObjectName;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    @Override
    public int compareTo(ScheduledMission other) {
        return this.startTime.compareTo(other.startTime);
    }
}
