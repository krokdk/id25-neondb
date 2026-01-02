package com.id25.neondb.candidates.repo;

import com.id25.neondb.candidates.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepo extends JpaRepository<Answer, Long> {
}
