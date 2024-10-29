package org.telegram.resources;

public enum LinkName {
    TELEGRAM_URL("https://api.telegram.org/bot"),
    TELEGRAM_API_URL_BIBA(TELEGRAM_URL+"<YOUR_BOT_TOKEN>/"),
    TELEGRAM_API_URL_BOBA(TELEGRAM_URL+"<YOUR_BOT_TOKEN>/"),
    TELEGRAM_JSON_FILE_NAME("problem.json"),
    TELEGRAM_GET_UPDATES("getUpdates"),
    TELEGRAM_JSON_OBJECT_RESULT("result"),
    TELEGRAM_COMMAND_START("/start"),
    TELEGRAM_CHAT_ID("chatId"),
    TELEGRAM_TEXT("text"),
    TELEGRAM_SEND_MESSAGE_HELLO("Привет! Опиши свою проблему, и я приму заявку."),
    TELEGRAM_SEND_MESSAGE_ACCESS("Заявка принята! Спасибо, мы скоро свяжемся.");



    private  String type;

    LinkName(String type) {
        this.type = type;
    }
    public String getType(){
        return type;
    }
}
