package com.oceanbyte.reefercontrol.ui.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.oceanbyte.reefercontrol.R;

public class SplashFragmentDirections {
  private SplashFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSplashToLogin() {
    return new ActionOnlyNavDirections(R.id.action_splash_to_login);
  }

  @NonNull
  public static NavDirections actionSplashToReeferList() {
    return new ActionOnlyNavDirections(R.id.action_splash_to_reeferList);
  }

  @NonNull
  public static NavDirections actionSplashFragmentToMalfunctionReportListFragment() {
    return new ActionOnlyNavDirections(R.id.action_splashFragment_to_malfunctionReportListFragment);
  }
}
