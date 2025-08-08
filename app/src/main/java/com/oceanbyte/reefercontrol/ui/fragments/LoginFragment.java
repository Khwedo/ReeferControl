package com.oceanbyte.reefercontrol.ui.fragments;

import static java.security.AccessController.getContext;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.oceanbyte.reefercontrol.R;
import com.oceanbyte.reefercontrol.database.AppDatabase;
import com.oceanbyte.reefercontrol.models.UserProfile;
import com.oceanbyte.reefercontrol.session.UserSession;

import java.util.concurrent.Executors;

public class LoginFragment extends Fragment {
    private EditText emailInput, passwordInput;
    private Button loginButton;
    private AppDatabase db;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        emailInput = view.findViewById(R.id.editTextEmail);
        passwordInput = view.findViewById(R.id.editTextPassword);
        loginButton = view.findViewById(R.id.buttonLogin);
        db = AppDatabase.getInstance(requireContext());

        loginButton.setOnClickListener(v -> handleLogin());

        return view;
    }

    private void handleLogin() {
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(getContext(), "Fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        Executors.newSingleThreadExecutor().execute(() -> {
            UserProfile user = db.userProfileDao().login(email, password);
            requireActivity().runOnUiThread(() -> {
                if (user != null) {

                    UserSession.getInstance().login(requireContext(), user.fullName, user.role);
                    // Навигация к ReeferList
                    NavHostFragment.findNavController(this).navigate(R.id.action_login_to_reeferList);
                } else {
                    Toast.makeText(getContext(), "Invalid credentials", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}