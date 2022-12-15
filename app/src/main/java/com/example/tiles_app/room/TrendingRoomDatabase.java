package com.example.tiles_app.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.tiles_app.model.TrendingData;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {TrendingData.class}, version = 2, exportSchema = false)
public abstract class TrendingRoomDatabase extends RoomDatabase {

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private static volatile TrendingRoomDatabase INSTANCE;

    public static TrendingRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TrendingRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    TrendingRoomDatabase.class, "trending_db")
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract TrendingDao trendingDao();
}