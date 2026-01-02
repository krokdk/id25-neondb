package com.id25.neondb.candidates.service;

import com.id25.neondb.candidates.model.Candidate;
import com.id25.neondb.candidates.repo.CandidateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepo candidateRepo;

    public List<Candidate> list(){
        return candidateRepo.findAll();
    }

    public Candidate saveCandidate(Candidate candidate) {
        if (candidate.getContactInfo() != null) {
            candidate.getContactInfo().setCandidate(candidate);
        }


        return candidateRepo.save(candidate);
    }


    public Optional<Candidate> getCandidateById(Long id) {
        return candidateRepo.findById(id);
    }
}
