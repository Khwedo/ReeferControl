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

public class MalfunctionReportDetailFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private MalfunctionReportDetailFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private MalfunctionReportDetailFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static MalfunctionReportDetailFragmentArgs fromBundle(@NonNull Bundle bundle) {
    MalfunctionReportDetailFragmentArgs __result = new MalfunctionReportDetailFragmentArgs();
    bundle.setClassLoader(MalfunctionReportDetailFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("reportId")) {
      long reportId;
      reportId = bundle.getLong("reportId");
      __result.arguments.put("reportId", reportId);
    } else {
      throw new IllegalArgumentException("Required argument \"reportId\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static MalfunctionReportDetailFragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    MalfunctionReportDetailFragmentArgs __result = new MalfunctionReportDetailFragmentArgs();
    if (savedStateHandle.contains("reportId")) {
      long reportId;
      reportId = savedStateHandle.get("reportId");
      __result.arguments.put("reportId", reportId);
    } else {
      throw new IllegalArgumentException("Required argument \"reportId\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  public long getReportId() {
    return (long) arguments.get("reportId");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("reportId")) {
      long reportId = (long) arguments.get("reportId");
      __result.putLong("reportId", reportId);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("reportId")) {
      long reportId = (long) arguments.get("reportId");
      __result.set("reportId", reportId);
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
    MalfunctionReportDetailFragmentArgs that = (MalfunctionReportDetailFragmentArgs) object;
    if (arguments.containsKey("reportId") != that.arguments.containsKey("reportId")) {
      return false;
    }
    if (getReportId() != that.getReportId()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (int)(getReportId() ^ (getReportId() >>> 32));
    return result;
  }

  @Override
  public String toString() {
    return "MalfunctionReportDetailFragmentArgs{"
        + "reportId=" + getReportId()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull MalfunctionReportDetailFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(long reportId) {
      this.arguments.put("reportId", reportId);
    }

    @NonNull
    public MalfunctionReportDetailFragmentArgs build() {
      MalfunctionReportDetailFragmentArgs result = new MalfunctionReportDetailFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setReportId(long reportId) {
      this.arguments.put("reportId", reportId);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    public long getReportId() {
      return (long) arguments.get("reportId");
    }
  }
}
