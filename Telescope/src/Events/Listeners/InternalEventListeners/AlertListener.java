package Events.Listeners.InternalEventListeners;

import Events.Event;
import Events.EventDispatcher;
import Events.InternalEvents.InternalEvent;
import Events.InternalEvents.AlertEvents.Alertable;
import Storage.Repos.RepositoryFactory;
import Storage.Repos.AlertRepository;

public class AlertListener extends InternalEventListener {
    AlertRepository repo = RepositoryFactory.getAlertRepository();

    public static void register() {
        EventDispatcher.registerEventListener(new AlertListener());
    }

    public void onEvent(Event event) {
        if (event instanceof InternalEvent && event instanceof Alertable) {
            System.out.println("\tAlert logged successfully");
        }
    }
}
