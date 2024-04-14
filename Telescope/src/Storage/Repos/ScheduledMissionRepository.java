package Storage.Repos;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.List;
import java.util.ArrayList;
import Storage.ScheduledMission;

public class ScheduledMissionRepository implements Repository<ScheduledMission> {
    private static ScheduledMissionRepository instance;
    private final PriorityBlockingQueue<ScheduledMission> scheduledMissionQueue;

    private ScheduledMissionRepository(PriorityBlockingQueue<ScheduledMission> scheduledMissionQueue) {
        this.scheduledMissionQueue = scheduledMissionQueue;
    }

    public static synchronized ScheduledMissionRepository getInstance(PriorityBlockingQueue<ScheduledMission> scheduledMissionQueue) {
        if (instance == null) {
            instance = new ScheduledMissionRepository(scheduledMissionQueue);
        }
        return instance;
    }

    @Override
    public void add(ScheduledMission item) {
        scheduledMissionQueue.add(item);
    }

    @Override
    public ScheduledMission get(int id) {
        for (ScheduledMission mission : scheduledMissionQueue) {
            if (mission.getID() == id) {
                return mission;
            }
        }
        return null; // Return null if the item with the specified ID is not found
    }

    @Override
    public void remove(int id) {
        scheduledMissionQueue.removeIf(mission -> mission.getID() == id);
    }

    @Override
    public List<ScheduledMission> getAll() {
        return new ArrayList<>(scheduledMissionQueue);
    }

    public ScheduledMission peek() {
        return scheduledMissionQueue.peek();
    }
}
