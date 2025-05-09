package com.example.hw04_gymlog_v300.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.hw04_gymlog_v300.database.entities.GymLog;
import com.example.hw04_gymlog_v300.database.entities.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User... user);

    @Delete
    void delete(User user);

    @Query("Select * from " + GymLogDatabase.USER_TABLE + " Order by username")
    LiveData<List<User>> getAllUsers();

    @Query("Delete from " + GymLogDatabase.USER_TABLE)
    void deleteAll();

    @Query("Select * from " + GymLogDatabase.USER_TABLE + " WHERE username == :username")
    LiveData<User> getUserByUsername(String username);

    @Query("Select * from " + GymLogDatabase.USER_TABLE + " WHERE id == :userId")
    LiveData<User> getUserbyUserId(int userId);
}
