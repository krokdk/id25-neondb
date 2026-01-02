package com.id25.neondb.candidates.model;

import com.id25.neondb.Auditable;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "contactinfo")
public class Contactinfo extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "contactInfo", optional = false)
    private Candidate candidate;

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    @Column
    private String fullName;

    @Column
    private String preferredName;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private String party;

    @Column
    private String position;

    @Column
    private Long positionStart;

    @Column
    private Long positionEnd;

    @Column(name = "alt_email", nullable = false)
    private Set<String> altEmail = new HashSet<>();


    public Candidate getCandidate() {
        return candidate;
    }

    public Set<String> getAltEmail() {
        return altEmail;
    }

    public void setAltEmail(Set<String> altEmail) {
        this.altEmail = altEmail;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getPositionEnd() {
        return positionEnd;
    }

    public void setPositionEnd(Long positionEnd) {
        this.positionEnd = positionEnd;
    }

    public void setPositionStart(Long positionStart) {
        this.positionStart = positionStart;
    }

    public Long getPositionStart() {
        return positionStart;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}
