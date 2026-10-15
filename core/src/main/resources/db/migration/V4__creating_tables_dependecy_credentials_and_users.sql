ALTER TABLE users DROP COLUMN password;
ALTER TABLE users ADD CONSTRAINT uk_users_email UNIQUE (email);

ALTER TABLE credentials RENAME COLUMN email TO user_email;
ALTER TABLE users
  ADD CONSTRAINT fk_users_credentials_email
  FOREIGN KEY (email) REFERENCES credentials(user_email)
  ON UPDATE CASCADE ON DELETE CASCADE;