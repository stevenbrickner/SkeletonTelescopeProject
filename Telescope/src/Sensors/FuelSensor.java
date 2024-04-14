package Sensors;

import java.time.Duration;

public class FuelSensor extends Sensor {
    // Constants for low and high thresholds
    private static final double MIN_THRESHOLD = 0.0; // 0%
    private static final double MAX_THRESHOLD = 100.0; // 100%

    public FuelSensor(int sensorID, String sensorName, String sensorType, String description, Duration samplingRate) {
        super(sensorID, sensorName, sensorType, description, samplingRate);
        instantiateList();
    }

    private void instantiateList() {
        readings.add(new Reading("fuelReading", 0.0, MIN_THRESHOLD, MAX_THRESHOLD));
    }

    public double getFuelReading() {
        return readings.get(0).getValue();
    }

    public void updateReadings() {
        super.updateReadings();
    }
}
