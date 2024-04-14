package Managers;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Sensors.Reading;
import Sensors.Sensor;
import Storage.Repos.RepositoryFactory;
import Storage.Repos.SensorRepository;

public class SensorManager {
    private static SensorManager instance = null;
    private final SensorRepository sensorRepository = RepositoryFactory.getSensorRepository();
    private ExecutorService sensorExecutor;
    private final Map<Integer, Thread> sensorThreads;
    List<Sensor> sensors;

    private SensorManager() {
        this.sensorExecutor = Executors.newFixedThreadPool(8);
        this.sensors = sensorRepository.getAll();
        this.sensorThreads = new HashMap<>();
        activateMainSensors();
    }

    // Singleton instance creation method
    public static synchronized SensorManager getInstance() {
        if (instance == null) {
            instance = new SensorManager();
        }
        return instance;
    }

    // Start main sensor threads
    private void activateMainSensors() {
        System.out.println("\nActivating main sensors.");
        for (Sensor sensor : sensors) {
            if(sensor.getID() % 2 == 1){ // main sensor ID's are 1 spearated from their backup
                Thread sensorThread = new Thread(sensor);
                sensorThreads.put(sensor.getID(), sensorThread); // Associate thread with sensor ID
                sensorExecutor.execute(sensorThread);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Sensors initialized successfully.\n");
    }
    

    // Method to retrieve a specific sensor's thread
    public Thread getSensorThread(int sensorID) {
        return sensorThreads.get(sensorID);
    }

    public Map<String, List<String>> getSensorReadings() {
        Map<String, List<String>> sensorReadings = new HashMap<>();

        for (Sensor sensor : sensors) {
            List<String> sensorColumns = sensor.getReadings();
            String sensorName = sensor.getName();

            // Store the sensor name and its readings in the map
            sensorReadings.put(sensorName, sensorColumns);
        }

        return sensorReadings;
    }

       /*public void switchToBackupSensor(Sensor mainSensor) {
        int mainSensorID = mainSensor.getID();
        System.out.println("Main sensor ID: " + mainSensorID);
        // Retrieve the thread associated with the main sensor ID
        Thread mainSensorThread = sensorThreads.get(mainSensorID);
        if (mainSensorThread != null) {
            // Interrupt the main sensor thread
            System.out.println("Switching to " + mainSensor.getName() + " backup.");
            mainSensorThread.interrupt();
    
            // Remove the main sensor thread from the mapping
            sensorThreads.remove(mainSensorID);
    
            // Start the backup sensor thread in its place
            Sensor backupSensor = sensors.get(mainSensorID); // Get the backup sensor
            System.out.println("Backup sensor ID: " + backupSensor.getID());
            Thread backupSensorThread = new Thread(backupSensor);
            sensorThreads.put(mainSensorID + 1, backupSensorThread); // Map the backup sensor thread
            sensorExecutor.execute(backupSensorThread); // Start the backup sensor thread
            System.out.println("Switched to " + backupSensor.getName() + " backup successfully.");
        } else {
            System.out.println("Main sensor thread not found for ID: " + mainSensorID);
        }
    }*/
}
