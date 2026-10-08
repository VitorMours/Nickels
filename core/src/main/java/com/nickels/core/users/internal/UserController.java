package com.nickels.core.users.internal;

import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.nickels.core.users.UserService;
import com.nickels.core.users.UserDto;
import com.nickels.core.users.internal.CreatedUserRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("users")
@Tag(name="Users", description="Endpoint de operacoes relacionadas com o recurso de usuario")
public class UserController {

	private final UserService service;

	UserController(UserService service) {
		this.service = service;
	}


	@Operation(summary="Mostrar usuario com ID", description="Retorna um usuario sendo feito a busca com base no seu ID dentro do path")
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> findById(@PathVariable UUID id) {
        return service.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
	}


	@Operation(summary="Criacao de Usuario", description="Endpoint de criacao de usuario com base no json do body, e seguindo o padrao do schema do UserDto")
	@PostMapping
	public ResponseEntity<UserDto> create(@Valid @RequestBody CreatedUserRequest request){
		UserDto dto = service.create(request.name(), request.email(), request.password());
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}
}
