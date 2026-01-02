package com.id25.neondb.candidates.service;

import com.id25.neondb.candidates.model.Comment;
import com.id25.neondb.candidates.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepo commentRepo;

    public List<Comment> list(){
        return commentRepo.findAll();
    }

    public Comment saveCandidate(Comment comment) {

        return commentRepo.save(comment);
    }


    public Optional<Comment> getCommentById(Long id) {
        return commentRepo.findById(id);
    }
}
