package Events.Listeners.TelecommunicationListeners;

import Events.Event;
import Events.EventDispatcher;
import Events.Telecommunications.Telecommunication;

public class TelecommunicationAcknowledgement implements TelecommunicationListener {

    public static void register() {
        EventDispatcher.registerEventListener(new TelecommunicationAcknowledgement());
    }
    
    public void onEvent(Event event) {
        if(event instanceof Telecommunication) {
            System.out.println("\nTelecommunication received.");
        }
    }
}
