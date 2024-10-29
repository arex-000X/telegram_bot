package org.telegram.domain;

import org.telegram.entities.Problem;
import org.telegram.repository.TelegramRepository;

public class UseCaseProblem extends TelegramRepository {
    TelegramRepository problemRepository;

    UseCaseProblem(TelegramRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    public void handleProblem(Problem problem) {
        problemRepository.setProblem(problem);
    }
}
