package com.oceanbyte.reefercontrol.ui.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.oceanbyte.reefercontrol.R;

public class SettingsFragmentDirections {
  private SettingsFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSettingsToLogin() {
    return new ActionOnlyNavDirections(R.id.action_settings_to_login);
  }
}
