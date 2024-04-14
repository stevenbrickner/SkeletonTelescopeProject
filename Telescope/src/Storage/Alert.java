package Storage;

import java.time.Instant;

public class Alert {
    private int alertID;
    private Instant timestamp;
    private String alertType;
    private String severityLevel;
    private String description;

    public Alert(int alertID, Instant timestamp, String alertType, String severityLevel, String description) {
        this.alertID = alertID;
        this.timestamp = timestamp;
        this.alertType = alertType;
        this.severityLevel = severityLevel;
        this.description = description;
    }

    public int getAlertID() {
        return alertID;
    }

    public void setAlertID(int alertID) {
        this.alertID = alertID;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public String getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(String severityLevel) {
        this.severityLevel = severityLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
