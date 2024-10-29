package org.telegram.repository;

import org.telegram.entities.*;

public class TelegramRepository {
   private Chat chat;
   private Message message;
   private Update update;
   private User user;
   private Problem problem;

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public void setUpdate(Update update) {
        this.update = update;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public Update getUpdate() {
        return update;
    }

    public Chat getChat() {
        return chat;
    }

    public Message getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }

    public Problem getProblem() {
        return problem;
    }


}
