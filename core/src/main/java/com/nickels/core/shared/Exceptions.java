package com.nickels.core.shared;

public final class Exceptions {

    private Exceptions() {}

    public static class EmailAlreadyRegisteredException extends RuntimeException {
        public EmailAlreadyRegisteredException(String email) {
            super("E-mail já cadastrado: " + email);
        }
    }

    // futuras exceções do módulo entram aqui
}