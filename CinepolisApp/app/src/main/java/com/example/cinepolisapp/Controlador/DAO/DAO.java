package com.example.cinepolisapp.Controlador.DAO;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    Object create(Object object);
    Object update(Object object);
    Object get(Object key);
    List<T> getAll();
    Object delete(Object key);
}
