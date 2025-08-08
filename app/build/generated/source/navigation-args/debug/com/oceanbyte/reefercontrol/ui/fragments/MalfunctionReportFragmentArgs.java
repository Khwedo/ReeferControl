package com.oceanbyte.reefercontrol.ui.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class MalfunctionReportFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private MalfunctionReportFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private MalfunctionReportFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static MalfunctionReportFragmentArgs fromBundle(@NonNull Bundle bundle) {
    MalfunctionReportFragmentArgs __result = new MalfunctionReportFragmentArgs();
    bundle.setClassLoader(MalfunctionReportFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("containerNumber")) {
      String containerNumber;
      containerNumber = bundle.getString("containerNumber");
      if (containerNumber == null) {
        throw new IllegalArgumentException("Argument \"containerNumber\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("containerNumber", containerNumber);
    } else {
      __result.arguments.put("containerNumber", "");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static MalfunctionReportFragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    MalfunctionReportFragmentArgs __result = new MalfunctionReportFragmentArgs();
    if (savedStateHandle.contains("containerNumber")) {
      String containerNumber;
      containerNumber = savedStateHandle.get("containerNumber");
      if (containerNumber == null) {
        throw new IllegalArgumentException("Argument \"containerNumber\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("containerNumber", containerNumber);
    } else {
      __result.arguments.put("containerNumber", "");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getContainerNumber() {
    return (String) arguments.get("containerNumber");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("containerNumber")) {
      String containerNumber = (String) arguments.get("containerNumber");
      __result.putString("containerNumber", containerNumber);
    } else {
      __result.putString("containerNumber", "");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("containerNumber")) {
      String containerNumber = (String) arguments.get("containerNumber");
      __result.set("containerNumber", containerNumber);
    } else {
      __result.set("containerNumber", "");
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    MalfunctionReportFragmentArgs that = (MalfunctionReportFragmentArgs) object;
    if (arguments.containsKey("containerNumber") != that.arguments.containsKey("containerNumber")) {
      return false;
    }
    if (getContainerNumber() != null ? !getContainerNumber().equals(that.getContainerNumber()) : that.getContainerNumber() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getContainerNumber() != null ? getContainerNumber().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "MalfunctionReportFragmentArgs{"
        + "containerNumber=" + getContainerNumber()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull MalfunctionReportFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public MalfunctionReportFragmentArgs build() {
      MalfunctionReportFragmentArgs result = new MalfunctionReportFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setContainerNumber(@NonNull String containerNumber) {
      if (containerNumber == null) {
        throw new IllegalArgumentException("Argument \"containerNumber\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("containerNumber", containerNumber);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public String getContainerNumber() {
      return (String) arguments.get("containerNumber");
    }
  }
}
