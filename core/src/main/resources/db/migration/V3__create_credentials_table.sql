-- Criacao de tabela de credenciais, com chave estrangeira
-- para a tabela de usuario, de forma que retira a senha de dentro das informacoes do usuario



CREATE TABLE credentials(
    id          UUID                     PRIMARY KEY,
    email       VARCHAR(255)             NOT NULL,
    password    VARCHAR(255)             NOT NULL,
    created_at   TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at   TIMESTAMP WITH TIME ZONE NOT NULL,

    CONSTRAINT uk_credentials_email UNIQUE (email)
);

