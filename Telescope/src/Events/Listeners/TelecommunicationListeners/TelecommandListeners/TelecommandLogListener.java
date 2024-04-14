package Events.Listeners.TelecommunicationListeners.TelecommandListeners;

import Events.Event;
import Events.EventDispatcher;
import Events.Telecommunications.Telecommunication;
import Storage.Repos.RepositoryFactory;
import Storage.Repos.TelecommandLogRepository;

public class TelecommandLogListener implements TelecommandListener {
    TelecommandLogRepository repo = RepositoryFactory.getTelecommandLogRepository();

    public static void register() {
        EventDispatcher.registerEventListener(new TelecommandLogListener());
    }

    public void onEvent(Event event) {
        if (event instanceof Telecommunication) {
            System.out.println("\nTelecommand logged successfully");
        }
    }
}