package com.id25.neondb.api;

import com.id25.neondb.candidates.model.Answer;
import com.id25.neondb.candidates.model.Candidate;
import com.id25.neondb.candidates.service.AnswerService;
import com.id25.neondb.candidates.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/candidates")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @PostMapping
    public ResponseEntity<Long> createCandidate(
            @RequestBody Candidate request
    ) {
        var saved = candidateService.saveCandidate(request);

        return ResponseEntity
                .created(URI.create("/candidates/" + saved.getId()))
                .body(saved.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidate> getProductById(@PathVariable Long id) {
        return candidateService
                .getCandidateById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
