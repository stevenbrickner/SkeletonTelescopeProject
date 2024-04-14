package Events;

import java.io.Serializable;
import java.time.Instant;

public interface Event extends Serializable, Comparable<Event> {
    Instant getTimestamp();
    int getPriority();

    @Override
    default int compareTo(Event other) {
        // Compare based on priority
        return Integer.compare(this.getPriority(), other.getPriority());
    }
}