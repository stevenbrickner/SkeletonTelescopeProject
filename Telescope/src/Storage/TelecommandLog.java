package Storage;

import java.time.Instant;

public class TelecommandLog {
    private int commandID;
    private Instant timestamp;
    private String commandName;
    private String[] commandParameters;
    private String priority;

    public TelecommandLog(int commandID, Instant timestamp, String commandName, String[] commandParameters, String priority) {
        this.commandID = commandID;
        this.timestamp = timestamp;
        this.commandName = commandName;
        this.commandParameters = commandParameters;
        this.priority = priority;
    }
    
    public int getCommandID() {
        return commandID;
    }

    public void setCommandID(int commandID) {
        this.commandID = commandID;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public String[] getCommandParameters() {
        return commandParameters;
    }

    public void setCommandParameters(String[] commandParameters) {
        this.commandParameters = commandParameters;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }


}
