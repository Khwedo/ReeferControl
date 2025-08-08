package com.oceanbyte.reefercontrol.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oceanbyte.reefercontrol.R;
import com.oceanbyte.reefercontrol.models.Alarm;

import java.util.List;

public class AlarmAdapter extends RecyclerView.Adapter<AlarmAdapter.AlarmViewHolder> {

    private List<Alarm> alarmList;
    private OnAlarmClickListener clickListener;
    private OnAlarmLongClickListener longClickListener;

    public interface OnAlarmClickListener {
        void onClick(Alarm alarm);
    }

    public interface OnAlarmLongClickListener {
        void onLongClick(Alarm alarm);
    }

    public void setOnAlarmClickListener(OnAlarmClickListener listener) {
        this.clickListener = listener;
    }

    public void setOnAlarmLongClickListener(OnAlarmLongClickListener listener) {
        this.longClickListener = listener;
    }

    public void setAlarmList(List<Alarm> alarmList) {
        if (alarmList != null) {
            alarmList.sort((a1, a2) -> {
                if (a1.createdAt == null) return 1;
                if (a2.createdAt == null) return -1;
                return a2.createdAt.compareTo(a1.createdAt); // Сортировка по убыванию даты
            });
        }
        this.alarmList = alarmList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AlarmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_alarm, parent, false);
        return new AlarmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlarmViewHolder holder, int position) {
        Alarm alarm = alarmList.get(position);
        holder.bind(alarm);
    }

    @Override
    public int getItemCount() {
        return alarmList != null ? alarmList.size() : 0;
    }

    class AlarmViewHolder extends RecyclerView.ViewHolder {

        TextView textViewAlarm;
        TextView textViewAlarmCreatedAt;
        AlarmViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewAlarm = itemView.findViewById(R.id.textViewAlarm);
            textViewAlarmCreatedAt = itemView.findViewById(R.id.textViewAlarmMeta);
        }

        void bind(Alarm alarm) {
            textViewAlarm.setText(alarm.alarmCode + ": " + alarm.description);

            String meta = "Created: " + alarm.createdAt;
            if (alarm.createdBy != null && !alarm.createdBy.isEmpty()) {
                meta += ", By: " + alarm.createdBy;
            }

            textViewAlarmCreatedAt.setText(meta);

            itemView.setOnClickListener(v -> {
                if (clickListener != null) clickListener.onClick(alarm);
            });

            itemView.setOnLongClickListener(v -> {
                if (longClickListener != null) {
                    longClickListener.onLongClick(alarm);
                    return true;
                }
                return false;
            });
        }
    }
}