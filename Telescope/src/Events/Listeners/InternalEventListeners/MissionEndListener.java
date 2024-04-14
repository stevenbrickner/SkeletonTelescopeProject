package Events.Listeners.InternalEventListeners;

import Events.Event;
import Events.EventDispatcher;
import Events.InternalEvents.MissionEndEvent;
import Storage.ScheduledMission;

public class MissionEndListener extends InternalEventListener {
    public static void register() {
        EventDispatcher.registerEventListener(new MissionEndListener());
    }
    
    public void onEvent(Event event) {
        if (event instanceof MissionEndEvent) {
            MissionEndEvent endEvent = (MissionEndEvent) event;
            ScheduledMission mission = endEvent.getMission();
            System.out.println("\tEnding mission " + mission.getMissionName()); 
        }
    }
}
