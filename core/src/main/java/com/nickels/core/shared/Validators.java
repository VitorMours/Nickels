package com.nickels.core.shared;

import java.util.regex.Pattern;

/**
 * Ferramentas de validacao de dados.
 *
 * Ferramentas de validacao de dados que podem ser usados
 * em todo o sistema de forma validar dados conforme padroes
 * necessarios para garantir a seguranca dos dados.
 *
 * @author Joao Vitor Rezende Moura
 * @since 10-06-2026
 * @version 0.1
 *
 */
public final class Validators {

    private static final Pattern EMAIL = Pattern.compile("^[^@\\s]+@([A-Za-z0-9]([A-Za-z0-9-]*[A-Za-z0-9])?\\.)+[A-Za-z]{2,}$");

    private Validators() {}

    /**
     * Validador de nulidade de um campo
     *
     * @param value valor que foi passado dentro do campo
     * @param field campo que esta sendo validado
     * @throws IllegalArgumentException se o parametro for obrigatorio dentro da estrutura
     *
     */
    public static String requireNotBlank(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Value is invalid");
        }
        return value;
    }

    /**
     * Validador de necessidade de email dentro da estrutura
     *
     * @param value valor do email que esta sendo passado
     * @throws IllegalArgumentException se o email estiver preenchido errado
     *
     */
    public static String requireEmail(String value) {
        requireNotBlank(value);
        if (!EMAIL.matcher(value).matches()) {
            throw new IllegalArgumentException("invalid email");
        }
        return value.toLowerCase();
    }
}
