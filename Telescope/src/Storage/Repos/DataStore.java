package Storage.Repos;

import java.time.Instant;
import java.time.Duration;
import java.util.List;
import java.util.Comparator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.PriorityBlockingQueue;

import Sensors.*;
import Storage.Alert;
import Storage.CelestialObject;
import Storage.ObservationData;
import Storage.ScheduledMission;
import Storage.TelecommandLog;

public class DataStore {
    private List<ObservationData> observationDataList;
    private PriorityBlockingQueue<ScheduledMission> scheduledMissionList;
    private List<Sensor> sensorList;
    private List<TelecommandLog> telecommandLogList;
    private List<Alert> alertList;
    private List<CelestialObject> celestialObjectList;

    protected DataStore() { // accessible only by package members
        observationDataList = new CopyOnWriteArrayList<>();
        scheduledMissionList = new PriorityBlockingQueue<>(10, Comparator.comparing(ScheduledMission::getStartTime));
        sensorList = new CopyOnWriteArrayList<>();
        telecommandLogList = new CopyOnWriteArrayList<>();
        alertList = new CopyOnWriteArrayList<>();
        celestialObjectList = new CopyOnWriteArrayList<>();

        scheduledMissionList.add(new ScheduledMission(1, "Andromeda Galaxy Imaging", "Andromeda Galaxy", Instant.parse("2025-03-26T08:00:00Z"), Instant.parse("2025-03-30T18:00:00Z")));
        scheduledMissionList.add(new ScheduledMission(2, "Betelgeuse Spectroscopy", "Betelgeuse", Instant.parse("2024-04-02T06:00:00Z"), Instant.parse("2024-04-10T17:00:00Z")));
        scheduledMissionList.add(new ScheduledMission(3, "Polaris Photometry", "Polaris", Instant.parse("2024-04-11T12:00:00Z"), Instant.parse("2024-04-20T14:00:00Z")));
        scheduledMissionList.add(new ScheduledMission(4, "Ceres Astrometry", "Ceres", Instant.parse("2024-04-21T09:00:00Z"), Instant.parse("2024-04-25T11:00:00Z")));
        scheduledMissionList.add(new ScheduledMission(5, "Orion Nebula Imaging", "Orion Nebula", Instant.parse("2024-04-26T06:00:00Z"), Instant.parse("2024-04-30T20:00:00Z")));
        scheduledMissionList.add(new ScheduledMission(6, "Whirlpool Galaxy Survey", "Whirlpool Galaxy", Instant.parse("2024-05-01T08:00:00Z"), Instant.parse("2024-05-15T15:00:00Z")));
        scheduledMissionList.add(new ScheduledMission(7, "Hale-Bopp Comet Photometry", "Hale-Bopp Comet", Instant.parse("2024-05-16T06:00:00Z"), Instant.parse("2024-05-22T23:00:00Z")));
        scheduledMissionList.add(new ScheduledMission(8, "Vesta Astrometry", "Vesta", Instant.parse("2024-05-23T10:00:00Z"), Instant.parse("2024-05-30T12:00:00Z")));
        scheduledMissionList.add(new ScheduledMission(9, "Eagle Nebula Imaging", "Eagle Nebula", Instant.parse("2024-06-01T08:00:00Z"), Instant.parse("2024-06-15T18:00:00Z")));
        scheduledMissionList.add(new ScheduledMission(10, "Halley's Comet Spectroscopy", "Halley's Comet", Instant.parse("2024-06-16T19:00:00Z"), Instant.parse("2024-06-22T21:00:00Z")));
        scheduledMissionList.add(new ScheduledMission(11, "Mars Polarimetry", "Mars", Instant.parse("2024-06-23T11:00:00Z"), Instant.parse("2024-06-30T13:00:00Z")));
        scheduledMissionList.add(new ScheduledMission(12, "Jupiter Astrometry", "Jupiter", Instant.parse("2024-07-01T07:00:00Z"), Instant.parse("2024-07-10T16:00:00Z")));
        scheduledMissionList.add(new ScheduledMission(13, "Test", "Jupiter", Instant.now().plusSeconds(25), Instant.now().plusSeconds(60)));



        sensorList.add(new Gyroscope(1, "GyroscopeM", "Gyroscope", "Main gyroscope sensor", Duration.ofMinutes(1)));
        sensorList.add(new Gyroscope(2, "GyroscopeB", "Gyroscope", "Backup gyroscope sensor", Duration.ofMinutes(1)));
        sensorList.add(new Accelerometer(3, "AccelerometerM", "Accelerometer", "Main accelerometer sensor", Duration.ofMinutes(3)));
        sensorList.add(new Accelerometer(4, "AccelerometerB", "Accelerometer", "Backup accelerometer sensor", Duration.ofMinutes(3)));
        sensorList.add(new TemperatureSensor(5, "TemperatureM", "Temperature", "Main temperature sensor", Duration.ofMinutes(5)));
        sensorList.add(new TemperatureSensor(6, "TemperatureB", "Temperature", "Backup temperature sensor", Duration.ofMinutes(5)));
        sensorList.add(new PowerSensor(7, "PowerM", "Power", "Main power sensor", Duration.ofMinutes(10)));
        sensorList.add(new PowerSensor(8, "PowerB", "Power", "Backup power sensor", Duration.ofMinutes(10)));
        sensorList.add(new RadiationSensor(9, "RadiationM", "Radiation", "Main radiation sensor", Duration.ofMinutes(10)));
        sensorList.add(new RadiationSensor(10, "RadiationB", "Radiation", "Backup radiation sensor", Duration.ofMinutes(10)));
        sensorList.add(new FuelSensor(11, "FuelM", "Fuel", "Main fuel sensor", Duration.ofDays(3)));
        sensorList.add(new FuelSensor(12, "FuelB", "Fuel", "Backup fuel sensor", Duration.ofDays(3)));
        sensorList.add(new LightSensor(13, "LightM", "Light", "Main light sensor", Duration.ofHours(1)));
        sensorList.add(new LightSensor(14, "LightB", "Light", "Backup light sensor", Duration.ofHours(1)));
        sensorList.add(new PressureSensor(15, "PressureM", "Pressure", "Main pressure sensor", Duration.ofMinutes(10)));
        sensorList.add(new PressureSensor(16, "PressureB", "Pressure", "Backup pressure sensor", Duration.ofMinutes(10)));

        celestialObjectList.add(new CelestialObject(1, "Andromeda Galaxy", "Galaxy", 10.68f, 41.27f, Instant.parse("2024-03-13T02:38:01Z")));
        celestialObjectList.add(new CelestialObject(2, "Betelgeuse", "Star", 88.79f, 7.41f, Instant.parse("2024-03-13T02:38:01Z")));
        celestialObjectList.add(new CelestialObject(3, "Callisto", "Moon", 142.6f, -21.22f, Instant.parse("2024-03-13T02:38:01Z")));
        celestialObjectList.add(new CelestialObject(4, "Ceres", "Asteroid", 291.05f, 11.86f, Instant.parse("2024-03-13T02:38:01Z")));
        celestialObjectList.add(new CelestialObject(5, "Deimos", "Moon", 31.16f, -25.47f, Instant.parse("2024-03-13T02:38:01Z")));
        celestialObjectList.add(new CelestialObject(6, "Eagle Nebula", "Nebula", 276.4f, -13.86f, Instant.parse("2024-03-13T02:38:01Z")));
        celestialObjectList.add(new CelestialObject(7, "Europa", "Moon", 89.5f, -21.05f, Instant.parse("2024-03-13T02:38:01Z")));
        celestialObjectList.add(new CelestialObject(8, "Ganymede", "Moon", 103.8f, -21.04f, Instant.parse("2024-03-13T02:38:01Z")));
        celestialObjectList.add(new CelestialObject(9, "Hale-Bopp Comet", "Comet", 95.87f, 22.01f, Instant.parse("2024-03-13T02:38:01Z")));
        celestialObjectList.add(new CelestialObject(10, "Halley's Comet", "Comet", 113.53f, -23.34f, Instant.parse("2024-03-13T02:38:01Z")));
        celestialObjectList.add(new CelestialObject(11, "Io", "Moon", 41.53f, -22.89f, Instant.parse("2024-03-13T02:38:01Z")));
        celestialObjectList.add(new CelestialObject(12, "Jupiter", "Planet", 268.057f, -22.7765f, Instant.parse("2024-03-13T02:38:01Z")));
        celestialObjectList.add(new CelestialObject(13, "Mars", "Planet", 317.681f, 52.8865f, Instant.parse("2024-03-13T02:38:01Z")));
        celestialObjectList.add(new CelestialObject(14, "Mercury", "Planet", 48.331f, 18.36f, Instant.parse("2024-03-13T02:38:01Z")));
        celestialObjectList.add(new CelestialObject(15, "Neptune", "Planet", 326.438f, -2.6081f, Instant.parse("2024-03-13T02:38:01Z")));
        celestialObjectList.add(new CelestialObject(16, "Orion Nebula", "Nebula", 83.82f, -5.39f, Instant.parse("2024-03-13T02:38:01Z")));
        celestialObjectList.add(new CelestialObject(17, "Phobos", "Moon", 31.16f, -25.47f, Instant.parse("2024-03-13T02:38:01Z")));
        celestialObjectList.add(new CelestialObject(18, "Polaris", "Star", 37.95f, 89.26f, Instant.parse("2024-03-13T02:38:01Z")));
        celestialObjectList.add(new CelestialObject(19, "Saturn", "Planet", 40.589f, 83.5372f, Instant.parse("2024-03-13T02:38:01Z")));
        celestialObjectList.add(new CelestialObject(20, "Titan", "Moon", 35.25f, -6.08f, Instant.parse("2024-03-13T02:38:01Z")));
        celestialObjectList.add(new CelestialObject(21, "Titania", "Moon", 77.37f, -19.93f, Instant.parse("2024-03-13T02:38:01Z")));
        celestialObjectList.add(new CelestialObject(22, "Triton", "Moon", 354.46f, -14.21f, Instant.parse("2024-03-13T02:38:01Z")));
        celestialObjectList.add(new CelestialObject(23, "Uranus", "Planet", 348.977f, -0.5957f, Instant.parse("2024-03-13T02:38:01Z")));
        celestialObjectList.add(new CelestialObject(24, "Venus", "Planet", 76.6799f, -22.6936f, Instant.parse("2024-03-13T02:38:01Z")));
        celestialObjectList.add(new CelestialObject(25, "Vesta", "Asteroid", 40.48f, 12.55f, Instant.parse("2024-03-13T02:38:01Z")));
    }

    protected List<ObservationData> getObservationDataList() {
        return observationDataList;
    }

    protected PriorityBlockingQueue<ScheduledMission> getScheduledMissionList() {
        return scheduledMissionList;
    }

    protected List<Sensor> getSensorList() {
        return sensorList;
    }
    

    List<TelecommandLog> getTelecommandLogList() {
        return telecommandLogList;
    }

    List<Alert> getAlertList() {
        return alertList;
    }

    List<CelestialObject> getCelestialObject() {
        return celestialObjectList;
    }
}
