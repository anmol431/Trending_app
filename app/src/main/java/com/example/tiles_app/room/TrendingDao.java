package com.example.tiles_app.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.tiles_app.model.TrendingData;

import java.util.List;

@Dao
public interface TrendingDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(List<TrendingData> tilesData);

    @Query("SELECT * FROM TrendingData")
    LiveData<List<TrendingData>> getAllData();

    @Query("DELETE FROM TrendingData")
    void deleteAllData();
}
