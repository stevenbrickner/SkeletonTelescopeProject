package Sensors;

import java.time.Duration;

public class Gyroscope extends Sensor {
    // Constants for minimum and maximum angle range
    private static final double MIN_ANGLE = -180.0; 
    private static final double MAX_ANGLE = 180.0; 
    
    // Constants for minimum and maximum w component range
    private static final double MIN_W_COMPONENT = -1.0; 
    private static final double MAX_W_COMPONENT = 1.0; 

    public Gyroscope(int sensorID, String sensorName, String sensorType, String description, Duration samplingRate) {
        super(sensorID, sensorName, sensorType, description, samplingRate);
        instantiateList();
    }

    private void instantiateList() {
        readings.add(new Reading("rightAscension", 0.0, MIN_ANGLE, MAX_ANGLE));
        readings.add(new Reading("declination", 0.0, MIN_ANGLE, MAX_ANGLE));
        readings.add(new Reading("xAngle", 0.0, MIN_ANGLE, MAX_ANGLE));
        readings.add(new Reading("yAngle", 0, MIN_ANGLE, MAX_ANGLE));
        readings.add(new Reading("zAngle", 0, MIN_ANGLE, MAX_ANGLE));
        readings.add(new Reading("wComponent", 0.0, MIN_W_COMPONENT, MAX_W_COMPONENT));
    }

    public double getRightAscensionReading() {
        return readings.get(0).getValue();
    }

    // Method to generate random right ascension reading
/*     public void takeRightAscensionReading() {
        //this.rightAscensionReading = ThreadLocalRandom.current().nextDouble(MIN_ANGLE, MAX_ANGLE);

        this.rightAscensionReading = -1000;
        System.out.println("\nAscension reading\n");
        if (true) {
            triggerEvent("Test", 1, this);
        }
    } */

    public double getDeclinationReading() {
        return readings.get(1).getValue();
    }

    // Method to generate random declination reading
/*     public void takeDeclinationReading() {
        this.declinationReading = ThreadLocalRandom.current().nextDouble(MIN_ANGLE, MAX_ANGLE);
    } */

    public double getxAngle() {
        return readings.get(2).getValue();
    }

    // Method to generate random x angle
/*     public void takeXAngle() {
        this.xAngle = ThreadLocalRandom.current().nextDouble(MIN_ANGLE, MAX_ANGLE);
    } */

    public double getyAngle() {
        return readings.get(3).getValue();
    }

    // Method to generate random y angle
/*     public void takeYAngle() {
        this.yAngle = ThreadLocalRandom.current().nextDouble(MIN_ANGLE, MAX_ANGLE);
    } */

    public double getzAngle() {
        return readings.get(4).getValue();
    }

    // Method to generate random z angle
/*     public void takeZAngle() {
        this.zAngle = ThreadLocalRandom.current().nextDouble(MIN_ANGLE, MAX_ANGLE);
    } */

    public double getwComponent() {
        return readings.get(5).getValue();
    }

    // Method to generate random w component
/*     public void takeWComponent() {
        this.wComponent = ThreadLocalRandom.current().nextDouble(MIN_W_COMPONENT, MAX_W_COMPONENT);
    } */

/*     public void updateReadings() {
        takeRightAscensionReading();
        takeDeclinationReading();
        takeXAngle();
        takeYAngle();
        takeZAngle();
        takeWComponent();
        super.updateReadings();
    } */
}