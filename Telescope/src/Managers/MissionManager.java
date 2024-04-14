package Managers;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Storage.ScheduledMission;
import Storage.Repos.RepositoryFactory;
import Storage.Repos.ScheduledMissionRepository;
import Events.EventDispatcher;
import Events.InternalEvents.MissionStartEvent;
import Events.InternalEvents.MissionEndEvent;

public class MissionManager {
    private static MissionManager instance = null;
    private ScheduledMissionRepository missionQueue = RepositoryFactory.getScheduledMissionRepository();
    private ExecutorService missionExecutor;
    private static volatile boolean running = false;

    private MissionManager() {
        // Private constructor to prevent instantiation
        this.missionExecutor = Executors.newSingleThreadExecutor();
        this.start();
    }

    public static synchronized MissionManager getInstance() {
        if (instance == null) {
            instance = new MissionManager();
        }
        return instance;
    }

    private void start() {
        running = true;
        System.out.println("\nStarting mission manager");
        missionExecutor.execute(this::processMissions);
    }

    private void processMissions() {
        while (running && !Thread.currentThread().isInterrupted()) {
            try {
                ScheduledMission nextMission = missionQueue.peek();
                
                // Check if the start time of the next mission has already passed
                Instant now = Instant.now();
                if (nextMission.getStartTime().isBefore(now)) {
                    missionQueue.remove(nextMission.getID());
                    continue; // Skip processing this mission
                }
                
                long timeUntilStart = Duration.between(now, nextMission.getStartTime()).toMillis();
                System.out.println("Next mission is " + nextMission.getMissionName() + " at " + nextMission.getStartTime());
                if (timeUntilStart > 0) {
                    Thread.sleep(timeUntilStart);
                }
                
                // Generate MissionStartEvent
                EventDispatcher.dispatchEvent(new MissionStartEvent(1, nextMission));
    
                long missionDuration = Duration.between(nextMission.getStartTime(), nextMission.getEndTime()).toMillis();
                if (missionDuration > 0) {
                    Thread.sleep(missionDuration);
                }
                
                // Generate MissionEndEvent
                EventDispatcher.dispatchEvent(new MissionEndEvent(1, nextMission));
                
                // Remove the mission from the queue after it ends
                missionQueue.remove(nextMission.getID());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }    

    public void shutdown() {
        running = false;
        missionExecutor.shutdownNow();
    }
}
