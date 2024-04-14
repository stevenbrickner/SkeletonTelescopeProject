package Events.Listeners.InternalEventListeners;

import Events.Event;
import Events.EventDispatcher;
import Events.InternalEvents.MissionStartEvent;
import Storage.ScheduledMission;

public class MissionStartListener extends InternalEventListener {
    public static void register() {
        EventDispatcher.registerEventListener(new MissionStartListener());
    }

    public void onEvent(Event event) {
        if (event instanceof MissionStartEvent) {
            MissionStartEvent startEvent = (MissionStartEvent) event;
            ScheduledMission mission = startEvent.getMission();
            System.out.println("\tStarting mission " + mission.getMissionName()); 
        }
    }
}
