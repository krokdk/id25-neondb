package com.id25.neondb.candidates.service;

import com.id25.neondb.candidates.repo.CandidateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactInfoService {
    @Autowired
    private CandidateRepo candidateRepo;



}
