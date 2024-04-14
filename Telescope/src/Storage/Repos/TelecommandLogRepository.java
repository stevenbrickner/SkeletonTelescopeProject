package Storage.Repos;

import java.util.ArrayList;
import java.util.List;
import Storage.TelecommandLog;

public class TelecommandLogRepository implements Repository<TelecommandLog> {
    private static TelecommandLogRepository instance;
    private final List<TelecommandLog> telecommandLogList;

    private TelecommandLogRepository(List<TelecommandLog> telecommandLogList) {
        this.telecommandLogList = telecommandLogList;
    }

    public static synchronized TelecommandLogRepository getInstance(List<TelecommandLog> telecommandLogList) {
        if (instance == null) {
            instance = new TelecommandLogRepository(telecommandLogList);
        }
        return instance;
    }

    @Override
    public void add(TelecommandLog item) {
        telecommandLogList.add(item);
    }

    @Override
    public TelecommandLog get(int id) {
        for (TelecommandLog log : telecommandLogList) {
            if (log.getCommandID() == id) {
                return log;
            }
        }
        return null; // Return null if the item with the specified ID is not found
    }

    @Override
    public void remove(int id) {
        TelecommandLog logToRemove = null;
        for (TelecommandLog log : telecommandLogList) {
            if (log.getCommandID() == id) {
                logToRemove = log;
                break;
            }
        }
        if (logToRemove != null) {
            telecommandLogList.remove(logToRemove);
        }
    }

    @Override
    public List<TelecommandLog> getAll() {
    return new ArrayList<>(telecommandLogList);
    }
}
