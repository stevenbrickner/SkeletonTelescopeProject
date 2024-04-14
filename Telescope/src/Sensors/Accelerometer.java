package Sensors;

import java.time.Duration;

public class Accelerometer extends Sensor {
    // Constants for low and high thresholds
    private static final double MIN_THRESHOLD = 7.0; // Low threshold in km/h
    private static final double MAX_THRESHOLD = 9.0; // High threshold in km/h

    public Accelerometer(int sensorID, String sensorName, String sensorType, String description, Duration samplingRate) {
        super(sensorID, sensorName, sensorType, description, samplingRate);
        instantiateList();
    }

    private void instantiateList() {
        readings.add(new Reading("xAcceleration", 0.0, MIN_THRESHOLD, MAX_THRESHOLD));
        readings.add(new Reading("yAcceleration", 0.0, MIN_THRESHOLD, MAX_THRESHOLD));
        readings.add(new Reading("zAcceleration", 0.0, MIN_THRESHOLD, MAX_THRESHOLD));
    }

    public double getXAcceleration() {
        return readings.get(0).getValue();
    }

    public double getYAcceleration() {
        return readings.get(1).getValue();
    }

    public double getZAcceleration() {
        return readings.get(2).getValue();
    }
}
