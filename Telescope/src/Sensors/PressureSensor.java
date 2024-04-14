package Sensors;

import java.time.Duration;

public class PressureSensor extends Sensor {
    // Constants for low and high thresholds
    private static final double MIN_THRESHOLD = 0.0; // Example value, adjust as needed
    private static final double MAX_THRESHOLD = 2000.0; // Example value, adjust as needed

    public PressureSensor(int sensorID, String sensorName, String sensorType, String description, Duration samplingRate) {
        super(sensorID, sensorName, sensorType, description, samplingRate);
        instantiateList();
    }

    private void instantiateList() {
        readings.add(new Reading("pressureReading", 0.0, MIN_THRESHOLD, MAX_THRESHOLD));
    }

    public double getPressureReading() {
        return readings.get(0).getValue();
    }
}
