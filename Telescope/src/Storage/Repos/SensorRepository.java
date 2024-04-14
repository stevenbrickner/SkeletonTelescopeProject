package Storage.Repos;

import java.util.ArrayList;
import java.util.List;

import Sensors.Sensor;

public class SensorRepository implements Repository<Sensor> {
    private static SensorRepository instance;
    private final List<Sensor> sensorList;

    private SensorRepository(List<Sensor> sensorList) {
        this.sensorList = sensorList;
    }

    public static synchronized SensorRepository getInstance(List<Sensor> sensorList) {
        if (instance == null) {
            instance = new SensorRepository(sensorList);
        }
        return instance;
    }
    
    @Override
    public void add(Sensor item) {
        sensorList.add(item);
    }

    @Override
    public Sensor get(int id) {
        for (Sensor sensor : sensorList) {
            if (sensor.getID() == id) {
                return sensor;
            }
        }
        return null; // Return null if the sensor with the specified ID is not found
    }

    @Override
    public void remove(int id) {
        Sensor sensorToRemove = null;
        for (Sensor sensor : sensorList) {
            if (sensor.getID() == id) {
                sensorToRemove = sensor;
                break;
            }
        }
        if (sensorToRemove != null) {
            sensorList.remove(sensorToRemove);
        }
    }

    @Override
    public List<Sensor> getAll() {
    return new ArrayList<>(sensorList);
    }
}
