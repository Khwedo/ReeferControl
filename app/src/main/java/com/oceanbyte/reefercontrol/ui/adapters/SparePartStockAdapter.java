package com.oceanbyte.reefercontrol.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oceanbyte.reefercontrol.R;
import com.oceanbyte.reefercontrol.models.SparePartStock;

import java.util.List;

public class SparePartStockAdapter extends RecyclerView.Adapter<SparePartStockAdapter.ViewHolder> {

    private List<SparePartStock> parts;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onClick(SparePartStock part);
    }

    public void setOnItemClickListener(OnItemClickListener l) {
        this.listener = l;
    }

    public void setParts(List<SparePartStock> parts) {
        this.parts = parts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_spare_part_stock, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SparePartStock part = parts.get(position);
        holder.bind(part);
    }

    @Override
    public int getItemCount() {
        return parts != null ? parts.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewLine;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewLine = itemView.findViewById(R.id.textViewPartLine);
        }

        void bind(SparePartStock part) {
            textViewLine.setText(part.partNumber + " — " + part.description);
            itemView.setOnClickListener(v -> {
                if (listener != null) listener.onClick(part);
            });
        }
    }
}