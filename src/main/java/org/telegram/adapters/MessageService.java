package org.telegram.adapters;

import java.io.IOException;

public interface MessageService {
    void sendMessage(String chatId, String text) throws IOException;
}
