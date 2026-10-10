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
    public UUID id;


    @Column(nullable=false, unique=true)
    public String email;

    @Column(nullable=false)
    public String password;

    @Column
    public Instant createdAt;

    @Column
    public Instant updatedAt;



    private Credentials() {}



    public Credentials(String email, String password) {
        this.email = email;
        this.password = password;
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

    @Override
    public String toString() {
        return "Credential[id=%s, email=%s, password=%s]".formatted(id, email, password);
    }
}
