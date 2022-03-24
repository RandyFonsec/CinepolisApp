package com.example.cinepolisapp.Controlador.DAO;

import com.example.cinepolisapp.Utils.RetrofitSingleton;

import retrofit2.Retrofit;

public interface DAORetrofit extends DAO {
    static Retrofit retrofit = RetrofitSingleton.getInstance().getRetrofit();
}
