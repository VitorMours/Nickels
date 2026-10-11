ALTER TABLE users DROP COLUMN password;
ALTER TABLE users ADD CONSTRAINT uk_users_email UNIQUE (email);

ALTER TABLE credentials RENAME COLUMN email TO user_email;
ALTER TABLE credentials
    ADD CONSTRAINT fk_credentials_user_email
    FOREIGN KEY (user_email) REFERENCES users (email)
    ON UPDATE CASCADE
    ON DELETE CASCADE;