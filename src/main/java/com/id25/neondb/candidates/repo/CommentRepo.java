package com.id25.neondb.candidates.repo;

import com.id25.neondb.candidates.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
