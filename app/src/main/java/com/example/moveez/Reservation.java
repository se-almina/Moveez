package com.example.moveez;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "reservations")
public class Reservation {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String movie_name ;
    private String projection;
    private long user_id;
    

    public Reservation(String movie_name, String projection, long user_id) {
        this.movie_name = movie_name;
        this.projection = projection;
        this.user_id= user_id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public void setProjection(String projection) {
        this.projection = projection;
    }

    public long getId() {
        return id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public String getProjection() {
        return projection;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
}
