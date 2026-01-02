package com.id25.neondb.candidates.service;

import com.id25.neondb.candidates.model.Answer;
import com.id25.neondb.candidates.repo.AnswerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepo answerRepo;

    public Answer saveAnswer(Answer answer) {
        return answerRepo.save(answer);
    }
}
