package Storage;

public class ObservationData {
    int dataID;
    int missionID;
    byte[] observationData;

    public ObservationData(int dataID, int missionID, byte[] observationData) {
        this.dataID = dataID;
        this.missionID = missionID;
        this.observationData = observationData;
    }

    public int getID() {return dataID;}
}