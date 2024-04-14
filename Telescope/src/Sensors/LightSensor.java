package Sensors;

import java.time.Duration;

public class LightSensor extends Sensor {
    // Constants for low and high thresholds
    private static final double MIN_THRESHOLD = 0.0; // Lower bound for light intensity
    private static final double MAX_THRESHOLD = 1000.0; // Upper bound for light intensity

    public LightSensor(int sensorID, String sensorName, String sensorType, String description, Duration samplingRate) {
        super(sensorID, sensorName, sensorType, description, samplingRate);
        instantiateList();
    }

    private void instantiateList() {
        readings.add(new Reading("lightIntensity", 0.0, MIN_THRESHOLD, MAX_THRESHOLD));
    }

    public double getLightIntensity() {
        return readings.get(0).getValue();
    }
}
