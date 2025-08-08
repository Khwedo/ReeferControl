package com.oceanbyte.reefercontrol.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.oceanbyte.reefercontrol.models.MalfunctionReport;
import com.oceanbyte.reefercontrol.models.UserProfile;

import java.util.List;

@Dao
public interface UserProfileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(UserProfile user);

    @Query("SELECT * FROM user_profiles WHERE email = :email LIMIT 1")
    UserProfile getByEmail(String email);

    @Query("SELECT * FROM user_profiles WHERE email = :email AND password = :password LIMIT 1")
    UserProfile login(String email, String password);


    @Update
    void update(UserProfile profile);
    @Query("SELECT * FROM user_profiles ORDER BY id DESC LIMIT 1")
    List<UserProfile> getAll();

    @Query("SELECT * FROM user_profiles ORDER BY id DESC LIMIT 1")
    UserProfile getCurrentUser();

    @Query("DELETE FROM user_profiles")
    void clear();

}
