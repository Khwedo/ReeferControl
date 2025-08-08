package com.oceanbyte.reefercontrol.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.oceanbyte.reefercontrol.database.AppDatabase;
import com.oceanbyte.reefercontrol.database.dao.ReeferChatDao;
import com.oceanbyte.reefercontrol.models.ReeferChatMessage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executors;

public class ReeferChatViewModel extends ViewModel {
    private final LiveData<List<ReeferChatMessage>> messages;
    private final AppDatabase db;

    public ReeferChatViewModel(AppDatabase db, String reeferId) {
        this.db = db;
        this.messages = db.reeferChatDao().getMessagesForReefer(reeferId);
    }

    public LiveData<List<ReeferChatMessage>> getMessages() {
        return messages;
    }

    public void sendMessage(String reeferId, String role, String messageText) {
        ReeferChatMessage message = new ReeferChatMessage();
        message.reeferId = reeferId;
        message.senderRole = role;
        message.message = messageText;
        message.timestamp = new SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault()).format(new Date());

        Executors.newSingleThreadExecutor().execute(() -> db.reeferChatDao().insert(message));
    }
}
