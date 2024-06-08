package es.fitfemme.vista.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICrudControllerJpa <T>{
    List<T> getAllObjects();
    ResponseEntity<T> saveObject(T object);
    ResponseEntity<T> updateObject(int id, T object);
    ResponseEntity<Void> deleteObject(int id);
}
