package com.nickels.core.auth.internal;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("auth")
@Tag(name="Authentication", description="Endpeoints de operacoes relacionadas a autenticacao e autorizacao de usuarios dentro do sistema.")
public class CredentialController {

    @Operation(summary="Credenciais de Login", description="Verificar as credenciais de login necessarias para o usuario")
    @GetMapping("/login")
    public ResponseEntity<String> getLoginFields() {
        return ResponseEntity.ok().body("");
    }

    @Operation(summary="Login user", description="Acao de fazer login do usuario usando os dados do body")
    @PostMapping("/login")
    public void loginUser(@Valid @RequestBody LoginUserRequest login) {
        //TODO: Fazer validacao de usuario para que ele possa em vias de fato fazer o login
    }

    @Operation(summary="Credenciais de Signup", description="Verificar credenciais de signup necessarias para o usuario")
    @GetMapping("/signup")
    public ResponseEntity<String> getSignupFields() {
        return ResponseEntity.ok().body("");
    }

    @Operation(summary="Signup User", description="Acao de fazer signup do usuario usando os dados do bodye se ele ja nao tiver uma conta ja cadastrada")
    @PostMapping("/signup")
    public void signupUser() {
        //TODO: Fazer validacao de usuario para que ele possa em vias de fato criar a sua conta
    }
}
