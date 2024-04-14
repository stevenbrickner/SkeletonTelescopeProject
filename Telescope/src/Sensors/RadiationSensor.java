package Sensors;

import java.time.Duration;

public class RadiationSensor extends Sensor {
    // Constants for low and high thresholds
    private static final double MIN_THRESHOLD = 0.0; 
    private static final double MAX_THRESHOLD = 1000.0; 

    public RadiationSensor(int sensorID, String sensorName, String sensorType, String description, Duration samplingRate) {
        super(sensorID, sensorName, sensorType, description, samplingRate);
        instantiateList();
    }

    private void instantiateList() {
        readings.add(new Reading("radiationLevel", 0.0, MIN_THRESHOLD, MAX_THRESHOLD));
    }

    public double getRadiationLevel() {
        return readings.get(0).getValue();
    }

    public void updateReadings() {
        super.updateReadings();
    }
}
