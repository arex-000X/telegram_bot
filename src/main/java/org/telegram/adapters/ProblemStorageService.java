package org.telegram.adapters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.telegram.entities.Problem;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProblemStorageService {
    private static final Gson gson = new Gson();
    private final String fileName;

    public ProblemStorageService(String fileName) {
        this.fileName = fileName;
    }

    public void saveProblem(String username, String problemDescription) throws IOException {
        List<Problem> problems = loadProblems();
        problems.add(new Problem(username, problemDescription));
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(problems, writer);
        }
    }

    public List<Problem> loadProblems() throws IOException {
        if (!Files.exists(Path.of(fileName))) {
            return new ArrayList<>();
        }
        String json = new String(Files.readAllBytes(Path.of(fileName)));
        Type problemListType = new TypeToken<ArrayList<Problem>>() {
        }.getType();
        return gson.fromJson(json, problemListType);
    }
}
