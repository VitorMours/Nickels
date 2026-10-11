package com.nickels.core.auth.internal;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.util.UUID;
import java.time.Instant;


/**
 * Entidade Credentials
 *
 * Entidade que representa as credenciais do usuario de forma isolada
 * visando seguranca dos dados de maneira a isolar e pode anonimizar os
 * dados de maneira assincrona.
 *
 * @param email     Email do usuario que esta sendo salva
 * @param password  Senha do usuario que esta sendo salva
 *
 * @since 10-09-2026
 * @author Joao Vitor Rezende Moura
 */

@Entity
@Table(name="credentials")
public class Credentials {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;

    @Column(name = "user_email", nullable = false, unique = true)
    private String userEmail;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Instant createdAt;

    @Column(nullable = false)
    private Instant updatedAt;

    protected Credentials() {}

    public Credentials(String email, String password) {
        this.userEmail = email;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getPassword() {
        return password;
    }

    @PrePersist
    void onCreate() {
        var now = Instant.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    void onUpdate() {
        this.updatedAt = Instant.now();
    }

    @Override
    public String toString() {
        return "Credential[id=%s, email=%s, password=%s]".formatted(id, userEmail, password);
    }
}
