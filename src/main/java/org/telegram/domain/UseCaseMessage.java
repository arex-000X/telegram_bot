package org.telegram.domain;

import org.telegram.entities.Message;
import org.telegram.repository.TelegramRepository;

public class UseCaseMessage extends TelegramRepository {
    TelegramRepository messageRepository;
    UseCaseMessage(TelegramRepository messageRepository){
        this.messageRepository = messageRepository;
    }
    public void handleMessage(Message message){
        messageRepository.setMessage(message);
    }
}
