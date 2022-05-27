package com.example.regesapp.tu;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://script.google.com/macros/s/AKfycbwf-ShzLW93-YH8B446Wi8wz9UNk6I_BSo2Fpr6PSXTstsWYEqWHZd8K4ySsrM4vc35/";
    @GET("exec?action=getMaster")
    Call<List<Results>> getAPIMasterTU();
}