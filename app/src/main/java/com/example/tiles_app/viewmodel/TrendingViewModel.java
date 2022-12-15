package com.example.tiles_app.viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tiles_app.model.TrendingData;
import com.example.tiles_app.network.ApiClient;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TrendingViewModel extends ViewModel {
    public MutableLiveData<ArrayList<TrendingData>> data;
    private TrendingRepository tilesRepository;

    public void init(Context context) {
        tilesRepository = new TrendingRepository(context);
        data = new MutableLiveData<>();
    }

    public LiveData<List<TrendingData>> getAllData() {
        return tilesRepository.getAllData();
    }

    public void deleteTiles() {
        tilesRepository.delete();
    }

    public void getTrendingData() {
        Callback<ArrayList<TrendingData>> callback = new Callback<ArrayList<TrendingData>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<TrendingData>> call, Response<ArrayList<TrendingData>> response) {
                if (response.code() == 200) {
                    tilesRepository.insert(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<TrendingData>> call, Throwable t) {
                t.printStackTrace();
            }
        };

        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM).build();

        ApiClient.getClient().getTrendingData(body).enqueue(callback);
    }
}
