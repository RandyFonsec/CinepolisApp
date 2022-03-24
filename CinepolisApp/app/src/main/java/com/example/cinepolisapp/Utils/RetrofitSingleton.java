package com.example.cinepolisapp.Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {
    private Retrofit retrofit = null;
    public static RetrofitSingleton instance = null;
    private String BASE_URL = "https://anthophilous-baseli.000webhostapp.com/";
    private RetrofitSingleton() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static RetrofitSingleton getInstance() {
        if(instance == null)
            instance = new RetrofitSingleton();
        return instance;
    }

    public Retrofit getRetrofit() {
        return this.retrofit;
    }
}
