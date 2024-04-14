package Storage.Repos;

public class RepositoryFactory {
    private static DataStore dataStore = new DataStore();

    private RepositoryFactory() {
        // Private constructor to prevent instantiation
    }

    public static ObservationDataRepository getObservationDataRepository() {
        return ObservationDataRepository.getInstance(dataStore.getObservationDataList());
    }

    public static ScheduledMissionRepository getScheduledMissionRepository() {
        return ScheduledMissionRepository.getInstance(dataStore.getScheduledMissionList());
    }

    public static SensorRepository getSensorRepository() {
        return SensorRepository.getInstance(dataStore.getSensorList());
    }

    public static TelecommandLogRepository getTelecommandLogRepository() {
        return TelecommandLogRepository.getInstance(dataStore.getTelecommandLogList());
    }

    public static AlertRepository getAlertRepository() {
        return AlertRepository.getInstance(dataStore.getAlertList());
    }
}
