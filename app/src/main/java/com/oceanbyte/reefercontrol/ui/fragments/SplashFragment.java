package com.oceanbyte.reefercontrol.ui.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.oceanbyte.reefercontrol.R;
import com.oceanbyte.reefercontrol.session.UserSession;

public class SplashFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash, container, false);

        // ВОССТАНОВЛЕНИЕ СЕССИИ И SharedPreferences
        UserSession.getInstance().restore(requireContext());

        //Делает проверку, авторизован ли пользователь, и перенаправляет его на нужный экран
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            if (UserSession.getInstance().isLoggedIn()) {
                NavHostFragment.findNavController(this)
                        .navigate(R.id.action_splash_to_reeferList);
            } else {
                NavHostFragment.findNavController(this)
                        .navigate(R.id.action_splash_to_login);
            }
        }, 1000); // можно убрать задержку при необходимости

        return view;
    }
}