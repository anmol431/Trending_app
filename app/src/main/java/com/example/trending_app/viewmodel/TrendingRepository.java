package com.example.trending_app.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.trending_app.model.TrendingData;
import com.example.trending_app.room.TrendingDao;
import com.example.trending_app.room.TrendingRoomDatabase;

import java.util.List;

public class TrendingRepository {
    private final TrendingDao trendingDao;

    public TrendingRepository(Context context) {
        TrendingRoomDatabase db = TrendingRoomDatabase.getDatabase(context);
        trendingDao = db.trendingDao();
    }

    public LiveData<List<TrendingData>> getAllData() {
        return trendingDao.getAllData();
    }

    public void insert(List<TrendingData> list) {
        TrendingRoomDatabase.databaseWriteExecutor.execute(() -> trendingDao.insert(list));
    }

    public void delete() {
        TrendingRoomDatabase.databaseWriteExecutor.execute(trendingDao::deleteAllData);
    }
}