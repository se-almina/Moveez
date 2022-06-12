package com.example.moveez;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Movie.class, User.class, Reservation.class}, version = 3, exportSchema = false)
public abstract class MovieDatabase extends RoomDatabase {
    public abstract MovieDao movieDao();
    public abstract UserDao userDao();
    public abstract ReservationDao reservationDao();

    public static MovieDatabase INSTANCE=null;

    public static MovieDatabase getInstance(Context context) {
        if(INSTANCE==null) {
            INSTANCE= Room.databaseBuilder(context, MovieDatabase.class, "movie_database")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
}
