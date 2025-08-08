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

public class SparePartStockListFragmentDirections {
  private SparePartStockListFragmentDirections() {
  }

  @NonNull
  public static ActionSparePartStockListFragmentToSparePartStockDetailFragment actionSparePartStockListFragmentToSparePartStockDetailFragment(
      long partId) {
    return new ActionSparePartStockListFragmentToSparePartStockDetailFragment(partId);
  }

  public static class ActionSparePartStockListFragmentToSparePartStockDetailFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionSparePartStockListFragmentToSparePartStockDetailFragment(long partId) {
      this.arguments.put("partId", partId);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionSparePartStockListFragmentToSparePartStockDetailFragment setPartId(long partId) {
      this.arguments.put("partId", partId);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("partId")) {
        long partId = (long) arguments.get("partId");
        __result.putLong("partId", partId);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_sparePartStockListFragment_to_sparePartStockDetailFragment;
    }

    @SuppressWarnings("unchecked")
    public long getPartId() {
      return (long) arguments.get("partId");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionSparePartStockListFragmentToSparePartStockDetailFragment that = (ActionSparePartStockListFragmentToSparePartStockDetailFragment) object;
      if (arguments.containsKey("partId") != that.arguments.containsKey("partId")) {
        return false;
      }
      if (getPartId() != that.getPartId()) {
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
      result = 31 * result + (int)(getPartId() ^ (getPartId() >>> 32));
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionSparePartStockListFragmentToSparePartStockDetailFragment(actionId=" + getActionId() + "){"
          + "partId=" + getPartId()
          + "}";
    }
  }
}
