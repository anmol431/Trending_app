package com.example.trending_app.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.trending_app.model.TrendingData;

import java.util.List;

@Dao
public interface TrendingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<TrendingData> tilesData);

    @Query("SELECT * FROM trending_table")
    LiveData<List<TrendingData>> getAllData();

    @Query("DELETE FROM trending_table")
    void deleteAllData();
}
