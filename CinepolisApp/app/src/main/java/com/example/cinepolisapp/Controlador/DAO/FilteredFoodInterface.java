package com.example.cinepolisapp.Controlador.DAO;

import java.util.List;

public interface FilteredFoodInterface<T> {

    List<T> getAllAvailableFood();
    List<T> getAllAvailableFoodFiltered(Object key);

}
