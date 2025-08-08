package com.oceanbyte.reefercontrol.ui.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.oceanbyte.reefercontrol.R;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class MalfunctionReportListFragmentDirections {
  private MalfunctionReportListFragmentDirections() {
  }

  @NonNull
  public static ActionMalfunctionReportListToReportDetail actionMalfunctionReportListToReportDetail(
      long reportId) {
    return new ActionMalfunctionReportListToReportDetail(reportId);
  }

  public static class ActionMalfunctionReportListToReportDetail implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionMalfunctionReportListToReportDetail(long reportId) {
      this.arguments.put("reportId", reportId);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionMalfunctionReportListToReportDetail setReportId(long reportId) {
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
      return R.id.action_malfunctionReportList_to_reportDetail;
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
      ActionMalfunctionReportListToReportDetail that = (ActionMalfunctionReportListToReportDetail) object;
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
      return "ActionMalfunctionReportListToReportDetail(actionId=" + getActionId() + "){"
          + "reportId=" + getReportId()
          + "}";
    }
  }
}
