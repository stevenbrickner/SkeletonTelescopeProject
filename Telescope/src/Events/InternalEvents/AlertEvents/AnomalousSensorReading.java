package Events.InternalEvents.AlertEvents;

import java.time.Instant;

import Events.InternalEvents.InternalEvent;
import Sensors.Sensor;

public class AnomalousSensorReading implements InternalEvent, Alertable {

    private int priority;
    private Instant timestamp;

    private Sensor sensor;

    public AnomalousSensorReading(int priority, Sensor sensor) {
        this.priority = priority;
        this.timestamp = Instant.now();
        this.sensor = sensor;
    }

    public int getPriority() {
        return priority;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public Sensor getSensor() {
        return sensor;
    }
}
