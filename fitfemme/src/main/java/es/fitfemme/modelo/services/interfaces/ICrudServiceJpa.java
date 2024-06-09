package es.fitfemme.modelo.services.interfaces;

import java.util.List;

public interface ICrudServiceJpa<T> {
    List<T> getAllObjects();
    T saveObject(T object);
    T updateObject(T object);
    void deleteObject(int id);
    boolean existsById(int id);
}
