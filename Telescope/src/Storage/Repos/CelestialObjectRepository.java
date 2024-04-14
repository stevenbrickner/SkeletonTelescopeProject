package Storage.Repos;

import java.util.ArrayList;
import java.util.List;
import Storage.CelestialObject;

public class CelestialObjectRepository implements Repository<CelestialObject> {
    private static CelestialObjectRepository instance;
    private final List<CelestialObject> celestialObjectList;

    private CelestialObjectRepository(List<CelestialObject> celestialObjectList) {
        this.celestialObjectList = celestialObjectList;
    }

    public static synchronized CelestialObjectRepository getInstance(List<CelestialObject> celestialObjectList) {
        if (instance == null) {
            instance = new CelestialObjectRepository(celestialObjectList);
        }
        return instance;
    }

    @Override
    public void add(CelestialObject item) {
        celestialObjectList.add(item);
    }

    @Override
    public CelestialObject get(int id) {
        for (CelestialObject celestialObject : celestialObjectList) {
            if (celestialObject.getObjectID() == id) {
                return celestialObject;
            }
        }
        return null; // Or throw an exception indicating that the item with the specified ID was not found
    }

    @Override
    public void remove(int id) {
        CelestialObject celestialObjectToRemove = null;
        for (CelestialObject celestialObject : celestialObjectList) {
            if (celestialObject.getObjectID() == id) {
                celestialObjectToRemove = celestialObject;
                break;
            }
        }
        if (celestialObjectToRemove != null) {
            celestialObjectList.remove(celestialObjectToRemove);
        }
    }

    @Override
    public List<CelestialObject> getAll() {
        // Return a copy of the celestial object list
        return new ArrayList<>(celestialObjectList);
    }
}
