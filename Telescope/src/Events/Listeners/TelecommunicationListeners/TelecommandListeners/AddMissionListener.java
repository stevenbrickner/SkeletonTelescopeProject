package Events.Listeners.TelecommunicationListeners.TelecommandListeners;

import Events.Event;
import Events.EventDispatcher;
import Events.Telecommunications.Telecommands.AddMission;
import Storage.ScheduledMission;
import Storage.Repos.RepositoryFactory;
import Storage.Repos.ScheduledMissionRepository;

public class AddMissionListener implements TelecommandListener {

    public static void register() {
        EventDispatcher.registerEventListener(new AddMissionListener());
    }
    
    public void onEvent(Event event) {
        if (event instanceof AddMission) {
            AddMission command = (AddMission) event;
            ScheduledMission mission = command.getMission();
            ScheduledMissionRepository repo = RepositoryFactory.getScheduledMissionRepository();

            repo.add(mission);

            System.out.println("\tMission " + mission.getMissionName() + " added to data store.");
        }
    }
}
