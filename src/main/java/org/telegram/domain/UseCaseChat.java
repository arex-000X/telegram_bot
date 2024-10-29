package org.telegram.domain;

import org.telegram.entities.Chat;
import org.telegram.repository.TelegramRepository;

public class UseCaseChat extends TelegramRepository {
    TelegramRepository chatRepository;
    public UseCaseChat(TelegramRepository chatRepository){
        this.chatRepository = chatRepository;
    }
    public void handleChat(Chat chat){
        chatRepository.setChat(chat);
    }
}
