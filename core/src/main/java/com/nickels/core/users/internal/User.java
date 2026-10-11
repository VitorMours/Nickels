package com.nickels.core.users.internal;

import java.util.UUID;
import java.time.Instant;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

/**
 * Entidade de representacao do usuario.
 *
 * Entidade que representa o usuario dentro do sistema
 * na parte de dados de identificacao do usuario
 *
 * @param id        UUID de identificacao do usuario
 * @param name      Nome do usuario
 * @param email     Email do usuario
 * @param createdAt Timestamp que o usuario foi criado
 * @param updatedAt Timestamp que o usuario teve ultima modificacao
 *
 * @author Joao Vitor Rezende Moura
 * @version v0.0.3
 * @since 10-06-2026
 *
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Instant createdAt;

    @Column(nullable = false)
    private Instant updatedAt;

    // Required by the JPA
    protected User() {}

    /**
     * Construtor da entidade
     *
     * @param name  Nome do usuario
     * @param email Email do usuario
     *
     * @throws IllegalArgumentException caso as funcoes de validacao levantem erros
     */
    public User(String name, String email) {
        // ADICIONAR VALIDADORES ESTATICOS
        this.name = name;
        this.email = email;
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

    // Getters
    public UUID getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }

    @Override
    public String toString() {
        return "User[id=%s, name=%s, email=%s]".formatted(id, name, email);
    }
}