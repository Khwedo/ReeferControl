package com.oceanbyte.reefercontrol.ui.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.oceanbyte.reefercontrol.R;

public class LoginFragmentDirections {
  private LoginFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionLoginToReeferList() {
    return new ActionOnlyNavDirections(R.id.action_login_to_reeferList);
  }
}
