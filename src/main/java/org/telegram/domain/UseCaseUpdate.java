package org.telegram.domain;

import org.telegram.entities.Update;
import org.telegram.repository.TelegramRepository;

public class UseCaseUpdate extends TelegramRepository {
    TelegramRepository updateRepository;
    UseCaseUpdate(TelegramRepository updateRepository){
        this.updateRepository = updateRepository;
    }
    public void handleUpdate(Update update){
        updateRepository.setUpdate(update);
    }
}
