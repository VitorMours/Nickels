package com.nickels.core.auth.internal;

import com.nickels.core.auth.internal.Credential;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Id;
import jakarta.persistence.PreUpdate;

import java.time.Instant;
import java.util.UUID;


/**
 * Tokens de Verificacao
 *
 * Entidade que representa os tokens de verificacao dos usuarios
 * do sistema, de forma a representar as permissoes deles dentro do sistema
 *
 * @since 10-17-2026
 * @version 0.0.1
 * @author Joao Vitor Rezende Moura
 */
@Entity
@Table(name="verification_tokens")
public class VerificationTokens {

    @Id
    private UUID id;

    @ManyToOne(fetch=FetchType.LAZY, optional=false)
    @JoinColumn(name="credentials_id")
    private Credential credentials;

    @Column(unique=true, nullable=false)
    private String passwordHash;

    @Column(nullable=false)
    private Instant createdAt

    @Column(nullable=false)
    private Instant updatedAt


    protected VerificationTokens(){}


    public VerificationTokens(Credential credentials, String passwordHash) {
        this.credentials = credentials;
        this.passwordHash = paswordHash;
    }

    @PrePersist
    void onCreate() {
        var now = Instant.now();
        this.createdAt = now;
        this.updatedAt = now;

    }

    @PreUpdate
    void onUpdate() {
        var now = Instant.now();
        this.updatedAt = now;
    }


}
