package Storage.Repos;

import java.util.ArrayList;
import java.util.List;
import Storage.ObservationData;

public class ObservationDataRepository implements Repository<ObservationData> {
    private static ObservationDataRepository instance;
    private final List<ObservationData> observationDataList;

    private ObservationDataRepository(List<ObservationData> observationDataList) {
        this.observationDataList = observationDataList;
    }

    public static synchronized ObservationDataRepository getInstance(List<ObservationData> observationDataList) {
        if (instance == null) {
            instance = new ObservationDataRepository(observationDataList);
        }
        return instance;
    }

    @Override
    public void add(ObservationData item) {
        observationDataList.add(item);
    }

    @Override
    public ObservationData get(int id) {
        for (ObservationData data : observationDataList) {
            if (data.getID() == id) {
                return data;
            }
        }
        return null; // Return null if the item with the specified ID is not found
    }

    @Override
    public void remove(int id) {
        ObservationData dataToRemove = null;
        for (ObservationData data : observationDataList) {
            if (data.getID() == id) {
                dataToRemove = data;
                break;
            }
        }
        if (dataToRemove != null) {
            observationDataList.remove(dataToRemove);
        }
    }

    @Override
    public List<ObservationData> getAll() {
    return new ArrayList<>(observationDataList);
    }
}
