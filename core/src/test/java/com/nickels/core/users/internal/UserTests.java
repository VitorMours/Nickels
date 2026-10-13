package com.nickels.core.users.internal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.EmptySource;

class UserTest {

    @Test
    void deveCriarUsuarioComDadosValidos() {
        var user = new User("Vitor Moura","joaov.rezendemoura@gmail.com");
        assertThat(user.getName()).isEqualTo("Vitor Moura");
        assertThat(user.getEmail()).isEqualTo("joaov.rezendemoura@gmail.com");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t", "\n"})
    void deveRejeitarNomeVazio(String nomeInvalido) {
        assertThatThrownBy(() -> new User(nomeInvalido, "vitor@email.com"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Value is invalid");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t", "\n"})
    void deveRejeitarEmailVazio(String emailInvalido) {
        assertThatThrownBy(() -> new User("Vitor Moura", emailInvalido))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Value is invalid");
    }

    @ParameterizedTest
    @ValueSource(strings = {"invalid-email", "user@.com", "user@domain", "user@domain..com"})
    void deveRejeitarEmailComFormatoInvalido(String emailInvalido) {
        assertThatThrownBy(() -> new User("Vitor Moura", emailInvalido))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("invalid email");
    }

    @Test
    void deveExistirTimestampDeAtualizacaoECriacao() {
        var user = new User("Vitor Moura", "joaov.rezendemoura@gmail.com");
        user.onCreate();
        assertThat(user.getCreatedAt()).isNotNull();
        assertThat(user.getUpdatedAt()).isNotNull();
        assertThat(user.getCreatedAt()).isEqualTo(user.getUpdatedAt());
    }
    
    @Test
    void deveTimestampDeAtualizacaoDiferenteDoDeCriacaoAposAtualizacao() throws InterruptedException {
        var user = new User("Vitor Moura", "jaoov.rezendemoura@gmail.com");
        user.onCreate();
        var createdAt = user.getCreatedAt();
        Thread.sleep(10);
        user.onUpdate();
        assertThat(user.getUpdatedAt()).isNotNull();
        assertThat(user.getUpdatedAt()).isNotEqualTo(createdAt);
    }
}
