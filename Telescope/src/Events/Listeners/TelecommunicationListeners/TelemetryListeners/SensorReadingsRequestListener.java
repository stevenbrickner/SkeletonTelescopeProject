package Events.Listeners.TelecommunicationListeners.TelemetryListeners;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Map;

import Events.Event;
import Events.EventDispatcher;
import Events.Telecommunications.Telemetry.SensorReadingsRequest;
import Managers.Connection;
import Managers.SensorManager;

public class SensorReadingsRequestListener implements TelemetryListener {
    public static void register() {
        EventDispatcher.registerEventListener(new SensorReadingsRequestListener());
    }
    
    @Override
    public void onEvent(Event event) {
        if(event instanceof SensorReadingsRequest) {
            SensorReadingsRequest request = (SensorReadingsRequest) event;
            String host = request.getHost();
            int port = request.getPort();
            SensorManager manager = SensorManager.getInstance();
            Map<String, List<String>> sensorReadings = manager.getSensorReadings();

            Connection.sendToClient(host, port, "Data sent");
        }
    }
}
