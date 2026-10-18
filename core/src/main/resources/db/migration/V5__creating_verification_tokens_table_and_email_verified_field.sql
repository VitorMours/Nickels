CREATE TABLE verification_tokens (
    id              UUID                     NOT NULL,
    credentials_id  UUID                     NOT NULL,
    password_hash   VARCHAR(255)             NOT NULL,
    created_at      TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at      TIMESTAMP WITH TIME ZONE NOT NULL,

    CONSTRAINT pk_verification_tokens PRIMARY KEY (id),
    CONSTRAINT uk_verification_tokens_hash UNIQUE (password_hash),
    CONSTRAINT fk_verification_tokens_credentials
        FOREIGN KEY (credentials_id) REFERENCES credentials (id)
        ON DELETE CASCADE
);

CREATE INDEX idx_verification_tokens_credentials_id
    ON verification_tokens (credentials_id);


ALTER TABLE credentials (
    ADD COLUMN email_verified BOOLEAN NOT NULL DEFAULT FALSE
);
