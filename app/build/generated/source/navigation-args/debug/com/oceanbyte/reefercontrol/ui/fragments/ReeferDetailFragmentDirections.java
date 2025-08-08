package com.oceanbyte.reefercontrol.ui.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.oceanbyte.reefercontrol.R;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class ReeferDetailFragmentDirections {
  private ReeferDetailFragmentDirections() {
  }

  @NonNull
  public static ActionReeferDetailFragmentToMalfunctionReportDetailFragment actionReeferDetailFragmentToMalfunctionReportDetailFragment(
      long reportId) {
    return new ActionReeferDetailFragmentToMalfunctionReportDetailFragment(reportId);
  }

  @NonNull
  public static ActionReeferDetailToMalfunctionReport actionReeferDetailToMalfunctionReport() {
    return new ActionReeferDetailToMalfunctionReport();
  }

  public static class ActionReeferDetailFragmentToMalfunctionReportDetailFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionReeferDetailFragmentToMalfunctionReportDetailFragment(long reportId) {
      this.arguments.put("reportId", reportId);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionReeferDetailFragmentToMalfunctionReportDetailFragment setReportId(long reportId) {
      this.arguments.put("reportId", reportId);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("reportId")) {
        long reportId = (long) arguments.get("reportId");
        __result.putLong("reportId", reportId);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_reeferDetailFragment_to_malfunctionReportDetailFragment;
    }

    @SuppressWarnings("unchecked")
    public long getReportId() {
      return (long) arguments.get("reportId");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionReeferDetailFragmentToMalfunctionReportDetailFragment that = (ActionReeferDetailFragmentToMalfunctionReportDetailFragment) object;
      if (arguments.containsKey("reportId") != that.arguments.containsKey("reportId")) {
        return false;
      }
      if (getReportId() != that.getReportId()) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (int)(getReportId() ^ (getReportId() >>> 32));
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionReeferDetailFragmentToMalfunctionReportDetailFragment(actionId=" + getActionId() + "){"
          + "reportId=" + getReportId()
          + "}";
    }
  }

  public static class ActionReeferDetailToMalfunctionReport implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionReeferDetailToMalfunctionReport() {
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionReeferDetailToMalfunctionReport setContainerNumber(
        @NonNull String containerNumber) {
      if (containerNumber == null) {
        throw new IllegalArgumentException("Argument \"containerNumber\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("containerNumber", containerNumber);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("containerNumber")) {
        String containerNumber = (String) arguments.get("containerNumber");
        __result.putString("containerNumber", containerNumber);
      } else {
        __result.putString("containerNumber", "");
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_reeferDetail_to_malfunctionReport;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getContainerNumber() {
      return (String) arguments.get("containerNumber");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionReeferDetailToMalfunctionReport that = (ActionReeferDetailToMalfunctionReport) object;
      if (arguments.containsKey("containerNumber") != that.arguments.containsKey("containerNumber")) {
        return false;
      }
      if (getContainerNumber() != null ? !getContainerNumber().equals(that.getContainerNumber()) : that.getContainerNumber() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getContainerNumber() != null ? getContainerNumber().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionReeferDetailToMalfunctionReport(actionId=" + getActionId() + "){"
          + "containerNumber=" + getContainerNumber()
          + "}";
    }
  }
}
