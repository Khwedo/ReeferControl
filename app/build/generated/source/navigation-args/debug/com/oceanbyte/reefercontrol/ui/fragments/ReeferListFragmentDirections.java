package com.oceanbyte.reefercontrol.ui.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.oceanbyte.reefercontrol.R;

public class ReeferListFragmentDirections {
  private ReeferListFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionReeferListToReeferDetail() {
    return new ActionOnlyNavDirections(R.id.action_reeferList_to_reeferDetail);
  }
}
