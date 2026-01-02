package com.id25.neondb.candidates.model;

import com.id25.neondb.Auditable;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "CANDIDATE")
public class Candidate extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            optional = false,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "contactinfo_id",
            nullable = false,
            unique = true
    )
    private Contactinfo contactInfo;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Answer> answers;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments;

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;

        if (comments != null) {
            comments.forEach(a -> a.setCandidate(this));
        }
    }

    public void setContactInfo(Contactinfo contactInfo) {
        this.contactInfo = contactInfo;
        if (contactInfo != null) {
            contactInfo.setCandidate(this);
        }
    }

    public Contactinfo getContactInfo() {
        return contactInfo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
        if (answers != null) {
            answers.forEach(a -> a.setCandidate(this));
        }
    }

    public Set<Answer> getAnswers() {
        return answers;
    }
}
