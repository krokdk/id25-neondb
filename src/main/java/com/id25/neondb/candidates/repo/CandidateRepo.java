package com.id25.neondb.candidates.repo;

import com.id25.neondb.candidates.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepo extends JpaRepository<Candidate, Long> {
}
