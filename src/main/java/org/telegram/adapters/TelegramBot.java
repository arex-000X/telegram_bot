package org.telegram.adapters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import org.telegram.entities.Problem;
import org.telegram.entities.Update;
import org.telegram.resources.*;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public abstract class TelegramBot implements MessageService,ProblemService,UpdateService {
    private final static Gson gson = new Gson();
    private String token;

    TelegramBot(String token){
        this.token = token;
    }
    //Получение обновлений
    @Override
    public List<Update> getUpdates() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(token + LinkName.TELEGRAM_GET_UPDATES)
                .build();
        Response response = client.newCall(request).execute();
        String responseBody = response.body().string();
        JSONObject jsonObject = new JSONObject(responseBody);
        Type typeLIst = new TypeToken<ArrayList<Update>>() {
        }.getType();
        return gson.fromJson(jsonObject.get("result").toString(), typeLIst);
    }

    //Обработка обновлений
    @Override
    public void processUpdate(Update update) throws IOException {
        if (update.message != null && update.message.text != null) {
            String chatId = update.message.chat.id.toString();
            String messageText = update.message.text;
            if (messageText.startsWith(LinkName.TELEGRAM_COMMAND_START.getType())) {
                sendMessage(chatId, LinkName.TELEGRAM_SEND_MESSAGE_HELLO.getType());
            } else {
                saveProblem(update.message.from.username, LinkName.TELEGRAM_SEND_MESSAGE_ACCESS.getType());
            }
        }
    }

    @Override
    public void saveProblem(String username, String problemDescription) throws IOException {
        List<Problem> problems = loadProblems();
        problems.add(new Problem(username,problemDescription));
        try(FileWriter writer = new FileWriter(LinkName.TELEGRAM_JSON_FILE_NAME.getType())){
            gson.toJson(problems,writer);
        }
    }

    @Override
    public List<Problem> loadProblems() throws IOException {
        return List.of();
    }

    @Override
    public void sendMessage(String chatId, String text) throws IOException {

    }
}
