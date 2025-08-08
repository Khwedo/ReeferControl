package com.oceanbyte.reefercontrol.ui.adapters;

import android.graphics.Color;
import android.view.*;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oceanbyte.reefercontrol.R;
import com.oceanbyte.reefercontrol.models.Reefer;
import com.oceanbyte.reefercontrol.models.ReeferChatMessage;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    private List<ReeferChatMessage> messages;
    private String currentUserRole = "";

    public void setMessages(List<ReeferChatMessage> messages) {
        this.messages = messages;
        notifyDataSetChanged();
    }
    public void setCurrentUserRole(String role) {
        this.currentUserRole = role;
    }

    @NonNull
    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_chat_message, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.ViewHolder holder, int position) {
        ReeferChatMessage message = messages.get(position);
        holder.bind(message, currentUserRole);
    }


    @Override
    public int getItemCount() {
        return messages != null ? messages.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewMessage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewMessage = itemView.findViewById(R.id.textViewMessage);
        }
        void bind(ReeferChatMessage message, String currentUserRole) {
            boolean isUnread = !message.senderRole.equals(currentUserRole)
                    && (message.readBy == null || !message.readBy.contains(currentUserRole));

            boolean isReadByAnyone = message.readBy != null && !message.readBy.isEmpty();

            // Формируем строку сообщения
            String line = "[" + message.senderRole + "] " + message.timestamp + " — " + message.message;
            if (isReadByAnyone) {
                line += " ✓"; // добавляем "✓", если кто-то прочитал
            }

            textViewMessage.setText(line);

            // Подсветка для непрочитанных текущим пользователем
            if (isUnread) {
                textViewMessage.setBackgroundColor(Color.parseColor("#FFEBEE")); // светло-розовый
            } else {
                textViewMessage.setBackgroundColor(Color.TRANSPARENT);
            }
        }
    }

}
