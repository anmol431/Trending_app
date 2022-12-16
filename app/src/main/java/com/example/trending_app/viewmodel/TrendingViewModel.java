package com.example.trending_app.viewmodel;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.trending_app.model.TrendingData;
import com.example.trending_app.network.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TrendingViewModel extends AndroidViewModel {
    private final TrendingRepository trendingRepository;
    public ObservableInt loading;
    public ObservableInt error;

    public TrendingViewModel(@NonNull Application application) {
        super(application);
        trendingRepository = new TrendingRepository(application.getApplicationContext());
        error = new ObservableInt(View.GONE);
        loading = new ObservableInt(View.GONE);
    }

    public LiveData<List<TrendingData>> getAllData() {
        return trendingRepository.getAllData();
    }

    public void deleteData() {
        trendingRepository.delete();
    }

    public void getTrendingData() {
        loading.set(View.VISIBLE);
        error.set(View.GONE);
        Callback<ArrayList<TrendingData>> callback = new Callback<ArrayList<TrendingData>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<TrendingData>> call, Response<ArrayList<TrendingData>> response) {
                loading.set(View.GONE);
                if (response.code() == 200) {
                    error.set(View.GONE);
                    trendingRepository.insert(response.body());
                } else {
                    error.set(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<TrendingData>> call, Throwable t) {
                error.set(View.VISIBLE);
                loading.set(View.GONE);
                t.printStackTrace();
            }
        };

        ApiClient.getClient().getTrendingData().enqueue(callback);
    }
}
