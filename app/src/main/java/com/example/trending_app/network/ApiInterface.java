package com.example.trending_app.network;

import com.example.trending_app.model.TrendingData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("testing")
    Call<ArrayList<TrendingData>> getTrendingData();


}
