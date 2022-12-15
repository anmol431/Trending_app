package com.example.tiles_app.network;

import com.example.tiles_app.model.TrendingData;

import java.util.ArrayList;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("testing")
    Call<ArrayList<TrendingData>> getTrendingData(@Body RequestBody requestBody);


}
