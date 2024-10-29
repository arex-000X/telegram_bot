package org.telegram.domain;

import org.telegram.entities.User;
import org.telegram.repository.TelegramRepository;

public class UseCaseUser extends TelegramRepository {
    TelegramRepository userRepository;
    UseCaseUser(TelegramRepository userRepository){
        this.userRepository = userRepository;
    }
    public void handleUser(User user){
        userRepository.setUser(user);
    }

}
