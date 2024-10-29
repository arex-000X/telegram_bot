package org.telegram.adapters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.*;
import org.json.JSONObject;
import org.telegram.entities.Update;
import org.telegram.resources.LinkName;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TelegramApiService {

    private static final OkHttpClient client = new OkHttpClient();
    private final String token;

    public TelegramApiService(String token) {
        this.token = token;
    }

    public List<Update> getUpdates() throws IOException {
        Request request = new Request.Builder()
                .url(token + LinkName.TELEGRAM_GET_UPDATES)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String responseBody = response.body().string();
            Type updateListType = new TypeToken<ArrayList<Update>>() {
            }.getType();
            return new Gson()
                    .fromJson(new JSONObject(responseBody)
                                    .get(LinkName.TELEGRAM_JSON_OBJECT_RESULT
                                            .getType())
                                    .toString(),
                            updateListType);
        }
    }

    public void sendMessage(String chatId, String text) throws IOException {
        RequestBody body = new FormBody.Builder()
                .add(LinkName.TELEGRAM_CHAT_ID.getType(), chatId)
                .add(LinkName.TELEGRAM_TEXT.getType(), text)
                .build();
        Request request = new Request.Builder()
                .url(LinkName.TELEGRAM_URL.getType())
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            // Обработка ответа, если нужно
        }
    }


}
