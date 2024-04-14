package Events.Listeners.InternalEventListeners;

import Sensors.Sensor;
import Events.Event;
import Events.EventDispatcher;
import Events.InternalEvents.AlertEvents.AnomalousSensorReading;

public class AnomalousSensorReadingListener extends InternalEventListener {

    public static void register() {
        EventDispatcher.registerEventListener(new AnomalousSensorReadingListener());
    }

    public void onEvent(Event event) {
        if (event instanceof AnomalousSensorReading) {
            AnomalousSensorReading reading = (AnomalousSensorReading) event;
            Sensor sensor = reading.getSensor();
            System.err.println("\tAnomalous sensor reading detected in \n\t\t" + sensor.getName());
        }
    }
}
