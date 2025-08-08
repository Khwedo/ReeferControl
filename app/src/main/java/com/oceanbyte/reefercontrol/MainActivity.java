package com.oceanbyte.reefercontrol;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.oceanbyte.reefercontrol.database.AppDatabase;
import com.oceanbyte.reefercontrol.database.dao.UserProfileDao;
import com.oceanbyte.reefercontrol.models.Alarm;
import com.oceanbyte.reefercontrol.models.Reefer;
import com.oceanbyte.reefercontrol.models.UserProfile;

import java.util.List;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private BottomNavigationView bottomNavView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация BottomNavigationView
        bottomNavView = findViewById(R.id.bottom_nav_view);

        // Получаем NavController из NavHostFragment
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        if (navHostFragment != null) {
            navController = navHostFragment.getNavController();
        }

        // Настройка BottomNavigationView с NavController
         NavigationUI.setupWithNavController(bottomNavView, navController);

        // Прячем BottomNav на экранах логина и сплэша
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if (destination.getId() == R.id.loginFragment || destination.getId() == R.id.splashFragment) {
                bottomNavView.setVisibility(View.GONE);
            } else {
                bottomNavView.setVisibility(View.VISIBLE);
            }


             // Инициализация базы данных и начальных данных
            AppDatabase db = AppDatabase.getInstance(this);
             Executors.newSingleThreadExecutor().execute(() -> {
            if (db.reeferDao().getAll().isEmpty()) {
                db.reeferDao().insertAll(List.of(
                        new Reefer(
                                "MSBU5287981",
                                "501882",
                                "Tokyo",
                                "New York",
                                "Feb 08",
                                "Mar 27",
                                "Maersk",
                                "Frozen Seafood",
                                "NORMAL",
                                true,
                                0,
                                -2,
                                0,
                                "28.07.2025",
                                "0"

                        ),
                        new Reefer(
                                "APZU1234567",
                                "501777",
                                "Shanghai",
                                "Los Angeles",
                                "Jan 12",
                                "Feb 04",
                                "COSCO",
                                "Chilled Meat",
                                "WARNING",
                                true,
                                2,
                                1,
                                2,
                                "28.07.2025",
                                "0"
                        ),
                        new Reefer(
                                "TLLU9988776",
                                "502101",
                                "Rotterdam",
                                "Buenos Aires",
                                "Mar 01",
                                "Mar 28",
                                "Hapag-Lloyd",
                                "Vegetables",
                                "DANGER",
                                true,
                                5.1,
                                4,
                                5,
                                "28.07.2025",
                                "0"
                        )
                ));
            }
        });
        Executors.newSingleThreadExecutor().execute(() -> {
            List<UserProfile> users = db.userProfileDao().getAll();

            if (users.isEmpty()) {
                db.userProfileDao().insert(new UserProfile("reader@example.com", "1234", "Reader Ivan", "READER"));
                db.userProfileDao().insert(new UserProfile("electric@example.com", "1234", "Electric John", "ELECTRIC"));
                db.userProfileDao().insert(new UserProfile("master@example.com", "1234", "Master Olga", "MASTER"));
                Log.d("DB_INIT", "Test users inserted");
            }
        });
        });

    }

}