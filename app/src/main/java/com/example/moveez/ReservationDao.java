package com.example.moveez;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
import java.util.Map;

@Dao
public interface ReservationDao {
    @Query("SELECT * FROM reservations")
    public List<Reservation> getAllReservation();

    @Insert
    public void addReservation(Reservation reservation );

    @Query("SELECT * FROM reservations WHERE user_id = :id")
    public List<Reservation> getReservation(long id);





}
