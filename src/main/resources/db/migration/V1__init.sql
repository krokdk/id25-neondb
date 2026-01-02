-- =========================
-- CONTACT INFO
-- =========================
CREATE TABLE contactinfo (
    id BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),

    full_name VARCHAR(255),
    preferred_name VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(255),
    party VARCHAR(255),
    position VARCHAR(255),

    position_start BIGINT,
    position_end BIGINT,

    alt_email VARCHAR(255)[] NOT NULL
);

-- =========================
-- CANDIDATE
-- =========================
CREATE TABLE candidate (
    id BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),

    contactinfo_id BIGINT NOT NULL UNIQUE,

    CONSTRAINT fk_candidate_contactinfo
        FOREIGN KEY (contactinfo_id)
        REFERENCES contactinfo(id)
        ON DELETE CASCADE
);

-- =========================
-- ANSWERS (N:1 -> Candidate)
-- =========================
CREATE TABLE answers (
    id BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),

    candidate_id BIGINT NOT NULL,

    party VARCHAR(255),
    election VARCHAR(255),
    constituency VARCHAR(255),

    answer1 VARCHAR(255),
    answer2 VARCHAR(255),
    answer3 VARCHAR(255),
    answer4 VARCHAR(255),
    answer5 VARCHAR(255),

    CONSTRAINT fk_answers_candidate
        FOREIGN KEY (candidate_id)
        REFERENCES candidate(id)
        ON DELETE CASCADE
);

-- =========================
-- COMMENT (N:1 -> Candidate)
-- =========================
CREATE TABLE comment (
    id BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),

    candidate_id BIGINT NOT NULL,
    comment VARCHAR(2000) NOT NULL,
    commenter VARCHAR(255) NOT NULL,

    CONSTRAINT fk_comment_candidate
        FOREIGN KEY (candidate_id)
        REFERENCES candidate(id)
        ON DELETE CASCADE
);

-- =========================
-- INDEKSER (valgfrit men anbefalet)
-- =========================
CREATE INDEX idx_answers_candidate_id
    ON answers(candidate_id);

CREATE INDEX idx_comment_candidate_id
    ON comment(candidate_id);
