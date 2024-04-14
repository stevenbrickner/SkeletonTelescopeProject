package Storage.Repos;

import java.util.List;

public interface Repository<T> {
    void add(T item);
    T get(int id);
    void remove(int id);
    List<T> getAll(); 
}