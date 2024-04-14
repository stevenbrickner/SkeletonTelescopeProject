import Managers.*;
import Events.EventDispatcher;
import Events.Listeners.InternalEventListeners.*;
import Events.Listeners.TelecommunicationListeners.TelecommandListeners.*;
import Events.Listeners.TelecommunicationListeners.TelemetryListeners.*;

public class Telescope {
    private static final int SERVER_PORT = 12345;
    String state;
    Connection connection;

    public Telescope() {
        connection = new Connection(SERVER_PORT);
    }

    public void start() {
        this.state = "Initializing components";
        // Register event listeners
        registerEventListeners();
        // Instantiate and start the sensor manager
        SensorManager sensorManager = SensorManager.getInstance();
        // 
        MissionManager missionManager = MissionManager.getInstance();
        // Allow for connections
        connection.start();
    }
    
    public static void registerEventListeners() {
        EventDispatcher.start();
        AlertListener.register();
        AnomalousSensorReadingListener.register();
        TelecommandLogListener.register();
        MissionStartListener.register();
        MissionEndListener.register();
        SensorReadingsRequestListener.register();
        AddMissionListener.register();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}