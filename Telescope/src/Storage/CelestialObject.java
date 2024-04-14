package Storage;

import java.time.Instant;

public class CelestialObject {
    private int objectID;
    private String objectName;
    private String type;
    private float rightAscension;
    private float declination;
    private Instant lastUpdated;

    public CelestialObject(int objectID, String objectName, String type, float rightAscension, float declination, Instant lastUpdated) {
        this.objectID = objectID;
        this.objectName = objectName;
        this.type = type;
        this.rightAscension = rightAscension;
        this.declination = declination;
        this.lastUpdated = lastUpdated;
    }

    public int getObjectID() {
        return objectID;
    }

    public void setObjectID(int objectID) {
        this.objectID = objectID;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getRightAscension() {
        return rightAscension;
    }

    public void setRightAscension(float rightAscension) {
        this.rightAscension = rightAscension;
    }

    public float getDeclination() {
        return declination;
    }

    public void setDeclination(float declination) {
        this.declination = declination;
    }

    public Instant getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Instant lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}