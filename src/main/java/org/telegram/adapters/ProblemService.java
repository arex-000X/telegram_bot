package org.telegram.adapters;

import java.io.IOException;
import java.util.List;

public interface ProblemService {
    void saveProblem(String username, String problemDescription) throws IOException;

    List<org.telegram.entities.Problem> loadProblems() throws IOException;
}
