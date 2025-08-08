package com.oceanbyte.reefercontrol.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_profiles")
public class UserProfile {
    @PrimaryKey(autoGenerate = true)
    public long id;

    @NonNull
    public String email;
    @NonNull
    public String password; // Временно, потом хэш или Firebase UID
    @NonNull
    public String fullName;


    @NonNull
    public String role; // "READER", "MASTER", "ELECTRIC"

    public UserProfile(@NonNull String email, @NonNull String password, @NonNull String fullName, @NonNull String role) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
    }
}
