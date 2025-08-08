package com.oceanbyte.reefercontrol.session;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class UserSession {
    private static final String PREF_NAME = "user_session";
    private static final String KEY_NAME = "name";
    private static final String KEY_ROLE = "role";
    private static UserSession instance;

    private String fullName;
    private String role;

    private UserSession() {}

    public static synchronized UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }
    // Сохраняет сессию в памяти и в SharedPreferences
    public void login(Context context, String fullName, String role) {
        this.fullName = fullName;
        this.role = role;
        Log.d("SESSION", "User logged in: " + fullName + " as " + role);

        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        prefs.edit()
                .putString(KEY_NAME, fullName)
                .putString(KEY_ROLE, role)
                .apply();
    }
    // Восстанавливает сессию при запуске приложения
    public void restore(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        this.fullName = prefs.getString(KEY_NAME, null);
        this.role = prefs.getString(KEY_ROLE, null);
    }

    // Очистка сессии
    public void logout(Context context) {
        fullName = null;
        role = null;

        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        prefs.edit().clear().apply();
    }

    public String getFullName() {
        return fullName;
    }

    public String getRole() {
        return role;
    }


    public boolean isLoggedIn() {
        return fullName != null && role != null;
    }

}
