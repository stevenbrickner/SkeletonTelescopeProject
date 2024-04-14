package Sensors;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import Events.EventDispatcher;
import Events.InternalEvents.AlertEvents.AnomalousSensorReading;

public class Sensor implements Runnable {
    private int sensorID;
    private String sensorName;
    private String sensorType;
    private String description;
    private Duration samplingRate;
    private Instant lastReadingTimestamp;
    protected List<Reading> readings;

    public Sensor(int sensorID, String sensorName, String sensorType, String description, Duration samplingRate) {
        this.sensorID = sensorID;
        this.sensorName = sensorName;
        this.sensorType = sensorType;
        this.description = description;
        this.samplingRate = samplingRate;
        this.readings = new ArrayList<Reading>();
        System.out.println("Sensor " + this.sensorName + " initialized.");
    }

    public int getID() {return sensorID;}

    public String getName() {return sensorName;}

    public String getType() {return sensorType;}

    public String getDescription() {return description;}

    public Instant getLastReadingTimestamp() {return lastReadingTimestamp;}

    public void setSamplingRate(Duration samplingRate) {
        this.samplingRate = samplingRate;
    }

    @Override
    public String toString() {
        return "\nID: " + sensorID + "\nName: " + sensorName + "\nType: " + sensorType + "\nDescription: " + description;
    }

    public void updateReadings() {
        this.lastReadingTimestamp = Instant.now();
        System.out.println(this.getType() + " taking readings at " + this.lastReadingTimestamp);

        for (Reading reading : readings) {
            double lowerBound = reading.getMinThreshold();
            double upperBound = reading.getMaxThreshold();

            double random = upperBound * 0.2; // ensure anomalous readings can be generated
            double value = ThreadLocalRandom.current().nextDouble(lowerBound - random, upperBound + random);
            reading.setValue(value);

            // generate event if applicable
            if(value > upperBound || value < lowerBound) {
                triggerEvent("AnomalousSensorReading", 1, this);
            }
        }
    };

    private void triggerEvent(String eventType, int priority, Sensor sensor) {
        switch (eventType) {
            case "AnomalousSensorReading":
                EventDispatcher.dispatchEvent(new AnomalousSensorReading(priority, sensor));
                break;
            default:
                System.out.println("Unknown event type: " + eventType);
                break;
        }
    }

    public List<String> getReadings() {
        List<String> sensorReadings = new ArrayList<>();
        for (Reading reading : readings) {
            // Assuming the format is "name: value"
            String readingInfo = reading.getName() + ": " + reading.getValue();
            sensorReadings.add(readingInfo);
        }
        return sensorReadings;
    }
    
    @Override
    public void run() {        
        while (!Thread.currentThread().isInterrupted()) {
            updateReadings();
            try {
                Thread.sleep(samplingRate.toMillis());
            } catch (InterruptedException e) {
                // Handle interruption by exiting the loop
                Thread.currentThread().interrupt(); // Restore interrupted status
                break;
            }
        }
    }
}
