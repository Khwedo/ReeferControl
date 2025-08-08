package com.oceanbyte.reefercontrol.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.oceanbyte.reefercontrol.R;
import com.oceanbyte.reefercontrol.models.Reefer;

import java.util.ArrayList;
import java.util.List;

public class ReeferAdapter extends RecyclerView.Adapter<ReeferAdapter.ReeferViewHolder> {

    private final List<Reefer> reefers = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    @NonNull
    @Override
    public ReeferViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_reefer, parent, false);
        return new ReeferViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReeferViewHolder holder, int position) {
        Reefer reefer = reefers.get(position);
        holder.bind(reefer);
    }

    @Override
    public int getItemCount() {
        return reefers.size();
    }

    public void submitList(List<Reefer> newList) {
        reefers.clear();
        reefers.addAll(newList);
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    class ReeferViewHolder extends RecyclerView.ViewHolder {

        TextView textContainerNumber, textPosition, textLoadingPort, textDischargePort, textAtd, textEta;
        ImageView iconShip;

        ReeferViewHolder(@NonNull View itemView) {
            super(itemView);
            textContainerNumber = itemView.findViewById(R.id.textContainerNumber);
            textPosition = itemView.findViewById(R.id.textPosition);
            textLoadingPort = itemView.findViewById(R.id.textLoadingPort);
            textDischargePort = itemView.findViewById(R.id.textDischargePort);
            textAtd = itemView.findViewById(R.id.textAtd);
            textEta = itemView.findViewById(R.id.textEta);
            iconShip = itemView.findViewById(R.id.iconShip);

            itemView.setOnClickListener(v -> {
                if (onItemClickListener != null && getBindingAdapterPosition() != RecyclerView.NO_POSITION) {
                    onItemClickListener.onItemClick(reefers.get(getBindingAdapterPosition()));
                }
            });
        }

        void bind(Reefer reefer) {
            textContainerNumber.setText(reefer.containerNumber);
            textPosition.setText("Pos: " + reefer.position);
            textLoadingPort.setText("Loading: " + reefer.loadingPort);
            textDischargePort.setText("Discharge: " + reefer.dischargePort);
            textAtd.setText("ATD: " + reefer.atd);
            textEta.setText("ETA: " + reefer.eta);

            // Цвет иконки судна в зависимости от статуса
            switch (reefer.status.toUpperCase()) {
                case "WARNING":
                    iconShip.setColorFilter(itemView.getContext().getColor(android.R.color.holo_orange_dark));
                    break;
                case "DANGER":
                    iconShip.setColorFilter(itemView.getContext().getColor(android.R.color.holo_red_dark));
                    break;
                default:
                    iconShip.setColorFilter(itemView.getContext().getColor(android.R.color.holo_green_dark));
                    break;
            }
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Reefer reefer);
    }
}