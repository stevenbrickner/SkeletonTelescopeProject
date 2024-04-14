package Sensors;

public class Reading {
    private String name;
    private double value;
    private double minThreshold;
    private double maxThreshold;

    public Reading(String name, double value, double minThreshold, double maxThreshold) {
        this.name = name;
        this.value = value;
        this.minThreshold = minThreshold;
        this.maxThreshold = maxThreshold;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public double getMinThreshold() {
        return minThreshold;
    }
    public void setMinThreshold(double minThreshold) {
        this.minThreshold = minThreshold;
    }
    public double getMaxThreshold() {
        return maxThreshold;
    }
    public void setMaxThreshold(double maxThreshold) {
        this.maxThreshold = maxThreshold;
    }
}