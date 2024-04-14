package Sensors;

import java.time.Duration;

public class TemperatureSensor extends Sensor {
    // Constants for low and high thresholds
    private static final double MIN_THRESHOLD = -273.15; // Absolute zero in Celsius
    private static final double MAX_THRESHOLD = 100.0; // Probably pretty hot

    public TemperatureSensor(int sensorID, String sensorName, String sensorType, String description, Duration samplingRate) {
        super(sensorID, sensorName, sensorType, description, samplingRate);
        instantiateList();
    }

    private void instantiateList() {
        readings.add(new Reading("temperature", 0.0, MIN_THRESHOLD, MAX_THRESHOLD));
    }

    public double getTemperature() {
        return readings.get(0).getValue();
    }
}
