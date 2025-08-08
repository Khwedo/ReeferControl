package com.oceanbyte.reefercontrol.ui.adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.oceanbyte.reefercontrol.R;
import com.oceanbyte.reefercontrol.models.relations.MalfunctionReportWithReefer;

import java.util.ArrayList;
import java.util.List;

public class MalfunctionReportAdapter extends RecyclerView.Adapter<MalfunctionReportAdapter.ReportViewHolder> {

    private List<MalfunctionReportWithReefer> reports = new ArrayList<>();

    public void setReports(List<MalfunctionReportWithReefer> reports) {
        this.reports = reports;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ReportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_malfunction_report, parent, false);
        return new ReportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportViewHolder holder, int position) {
        MalfunctionReportWithReefer item = reports.get(position);

        holder.textReportNumber.setText("Report: " + item.report.reportNumber);
        holder.textContainerNumber.setText("Container: " + item.reefer.containerNumber);
        holder.textPosition.setText("Position: " + item.reefer.position);
        holder.textStatus.setText("Status: " + item.reefer.status);

        holder.itemView.setOnClickListener(v -> {
            Bundle args = new Bundle();
            args.putLong("reportId", item.report.id); // используем item.report вместо report

            Navigation.findNavController(v).navigate(
                    R.id.action_malfunctionReportList_to_reportDetail,
                    args
            );
        });
    }

    @Override
    public int getItemCount() {
        return reports.size();
    }

    static class ReportViewHolder extends RecyclerView.ViewHolder {
        TextView textReportNumber, textContainerNumber, textPosition, textStatus;

        public ReportViewHolder(@NonNull View itemView) {
            super(itemView);
            textReportNumber = itemView.findViewById(R.id.textReportNumber);
            textContainerNumber = itemView.findViewById(R.id.textContainerNumber);
            textPosition = itemView.findViewById(R.id.textPosition);
            textStatus = itemView.findViewById(R.id.textStatus);
        }
    }
}
