package com.nickels.core.users.internal;

import com.nickels.core.users.internal.UserRepository;
import com.nickels.core.users.internal.User;
import com.nickels.core.users.UserService;
import com.nickels.core.users.UserDto;
import com.nickels.core.users.requests.CreatedUserRequest;
import com.nickels.core.users.events.UserRegisteredEvent;

import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.context.ApplicationEventPublisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserServiceImpl implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final ApplicationEventPublisher events;

    UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder, ApplicationEventPublisher events) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.events = events;
    }

    @Override
    @Transactional
    public UserDto create(CreatedUserRequest request) {
        if(repository.existsByEmail(request.email())) {
            log.warn("Tentativa de criação de usuário com email já cadastrado: {}", request.email());
            throw new IllegalArgumentException("Email ja cadastrado");
        }

        User user = repository.save(new User(request.name(), request.email()));

        events.publishEvent(new UserRegisteredEvent(
            user.getId(),
            user.getName(),
            user.getEmail(),
            passwordEncoder.encode(request.password())
        ));
        log.info("Usuario criado com sucesso: {}", user.getId());
        return toDto(user);
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<UserDto> findById(UUID id) {
        log.info("Buscando usuario com o id {}", id);
        return repository.findById(id).map(this::toDto);
    }

    private UserDto toDto(User u) {
        return new UserDto(u.getId(), u.getName(), u.getEmail());
    }
}
