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

public class SparePartStockDetailFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private SparePartStockDetailFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private SparePartStockDetailFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static SparePartStockDetailFragmentArgs fromBundle(@NonNull Bundle bundle) {
    SparePartStockDetailFragmentArgs __result = new SparePartStockDetailFragmentArgs();
    bundle.setClassLoader(SparePartStockDetailFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("partId")) {
      long partId;
      partId = bundle.getLong("partId");
      __result.arguments.put("partId", partId);
    } else {
      throw new IllegalArgumentException("Required argument \"partId\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static SparePartStockDetailFragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    SparePartStockDetailFragmentArgs __result = new SparePartStockDetailFragmentArgs();
    if (savedStateHandle.contains("partId")) {
      long partId;
      partId = savedStateHandle.get("partId");
      __result.arguments.put("partId", partId);
    } else {
      throw new IllegalArgumentException("Required argument \"partId\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  public long getPartId() {
    return (long) arguments.get("partId");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("partId")) {
      long partId = (long) arguments.get("partId");
      __result.putLong("partId", partId);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("partId")) {
      long partId = (long) arguments.get("partId");
      __result.set("partId", partId);
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
    SparePartStockDetailFragmentArgs that = (SparePartStockDetailFragmentArgs) object;
    if (arguments.containsKey("partId") != that.arguments.containsKey("partId")) {
      return false;
    }
    if (getPartId() != that.getPartId()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (int)(getPartId() ^ (getPartId() >>> 32));
    return result;
  }

  @Override
  public String toString() {
    return "SparePartStockDetailFragmentArgs{"
        + "partId=" + getPartId()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull SparePartStockDetailFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(long partId) {
      this.arguments.put("partId", partId);
    }

    @NonNull
    public SparePartStockDetailFragmentArgs build() {
      SparePartStockDetailFragmentArgs result = new SparePartStockDetailFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setPartId(long partId) {
      this.arguments.put("partId", partId);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    public long getPartId() {
      return (long) arguments.get("partId");
    }
  }
}
