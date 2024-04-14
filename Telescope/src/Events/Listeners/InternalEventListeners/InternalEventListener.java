package Events.Listeners.InternalEventListeners;

import Events.Event;
import Events.EventDispatcher;
import Events.Listeners.EventListener;

public class InternalEventListener implements EventListener {

    public static void register() {
        EventDispatcher.registerEventListener(new InternalEventListener());
    }

    public void onEvent(Event event) {
    }
}
