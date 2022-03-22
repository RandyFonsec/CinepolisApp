package com.example.cinepolisapp.Controlador.DAO;

import java.util.List;

public interface DAO {
    Object create(Object object);
    Object update(Object object);
    Object get(Object key);
    List<Object> getAll();
    boolean delete(Object key);
}
