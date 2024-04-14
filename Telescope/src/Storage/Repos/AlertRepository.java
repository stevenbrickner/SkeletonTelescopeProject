package Storage.Repos;

import java.util.ArrayList;
import java.util.List;
import Storage.Alert;

public class AlertRepository implements Repository<Alert> {
    private static AlertRepository instance;
    private final List<Alert> alertList;

    private AlertRepository(List<Alert> alertList) {
        this.alertList = alertList;
    }

    public static synchronized AlertRepository getInstance(List<Alert> alertList) {
        if (instance == null) {
            instance = new AlertRepository(alertList);
        }
        return instance;
    }

    @Override
    public void add(Alert item) {
        alertList.add(item);
    }

    @Override
    public Alert get(int id) {
        for (Alert alert : alertList) {
            if (alert.getAlertID() == id) {
                return alert;
            }
        }
        return null; // Return null if the item with the specified ID is not found
    }

    @Override
    public void remove(int id) {
        Alert alertToRemove = null;
        for (Alert alert : alertList) {
            if (alert.getAlertID() == id) {
                alertToRemove = alert;
                break;
            }
        }
        if (alertToRemove != null) {
            alertList.remove(alertToRemove);
        }
    }

    @Override
    public List<Alert> getAll() {
    return new ArrayList<>(alertList);
    }
}
