package org.telegram.adapters;

import org.telegram.entities.Update;
import org.telegram.resources.*;

import java.io.IOException;
import java.util.List;

public abstract class TelegramBot {
    private final TelegramApiService apiService;
    private final ProblemStorageService storageService;

    public TelegramBot(TelegramApiService apiService, ProblemStorageService storageService) {
        this.apiService = apiService;
        this.storageService = storageService;
    }

    public void processUpdate(Update update) throws IOException {
        if (update.message != null && update.message.text != null) {
            String chatId = update.message.chat.id.toString();
            String messageText = update.message.text;
            if (messageText.startsWith(LinkName.TELEGRAM_COMMAND_START.getType())) {
                apiService.sendMessage(chatId, LinkName.TELEGRAM_SEND_MESSAGE_HELLO.getType());
            } else {
                storageService.saveProblem(update.message.from.username, LinkName.TELEGRAM_SEND_MESSAGE_ACCESS.getType());
            }
        }
    }

    public List<Update> getUpdates() throws IOException {
        return apiService.getUpdates();
    }
}
