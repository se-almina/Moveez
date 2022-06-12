package com.example.moveez;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MovieDao {
        @Query("SELECT * FROM movies")
        public List<Movie> getAll();

        @Insert
        public void addMovie(Movie movie );

        @Update
        public void updateMovie(Movie movie);

        @Query("SELECT * FROM movies WHERE id = :id LIMIT 1")
        Movie getMovieById(long id);

        @Query("SELECT * FROM movies WHERE name = :name LIMIT 1")
        Movie getMovieByName(String name);
    }
