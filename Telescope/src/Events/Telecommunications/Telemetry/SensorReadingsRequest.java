package Events.Telecommunications.Telemetry;

import java.io.Serializable;
import java.time.Instant;

public class SensorReadingsRequest implements TelemetryRequest, Serializable {
    private static final long serialVersionUID = 1L;

    private Instant timestamp;
    private int priority;
    private String host;
    private int port;

    public SensorReadingsRequest(int priority, String host, int port) {
        this.timestamp = Instant.now();
        this.priority = priority;
        this.host = host;
        this.port = port;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public int getPriority() {
        return priority;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }
}
