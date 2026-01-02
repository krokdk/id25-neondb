package com.id25.neondb.api;

import com.id25.neondb.candidates.model.Answer;
import com.id25.neondb.candidates.model.Candidate;
import com.id25.neondb.candidates.repo.AnswerRepo;
import com.id25.neondb.candidates.repo.CandidateRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;

@RestController
@RequestMapping("/candidates/{candidateId}/answers")
public class AnswerController {

    private final CandidateRepo candidateRepo;
    private final AnswerRepo answerRepo;

    public AnswerController(CandidateRepo candidateRepo, AnswerRepo answerRepo) {
        this.candidateRepo = candidateRepo;
        this.answerRepo = answerRepo;
    }

    @PostMapping
    public ResponseEntity<Long> addAnswer(
            @PathVariable Long candidateId,
            @RequestBody Answer answer
    ) {
        Candidate candidate = candidateRepo.findById(candidateId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        answer.setCandidate(candidate);
        Answer saved = answerRepo.save(answer);

        return ResponseEntity
                .created(URI.create("/answers/" + saved.getId()))
                .body(saved.getId());
    }
}
