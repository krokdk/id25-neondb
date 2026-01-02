package com.id25.neondb.candidates;

import com.id25.neondb.candidates.model.Candidate;
import com.id25.neondb.candidates.repo.CandidateRepo;
import com.id25.neondb.candidates.service.CandidateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;


@DataJpaTest
@ActiveProfiles("test")
class CandidateRepoTest {

    @Autowired
    private CandidateRepo repository;

    @Test
    void shouldSaveAndLoadCandidate() {
        Candidate candidate = new Candidate();


        //candidate.setAddressId("Test Product");

        Candidate saved = repository.save(candidate);

        Candidate found = repository.findById(saved.getId()).orElseThrow();

        //assertThat(found.getAddressId()).isEqualTo("Test Product");
    }
}
