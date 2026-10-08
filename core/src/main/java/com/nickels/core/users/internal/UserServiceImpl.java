package com.nickels.core.users.internal;

import com.nickels.core.users.internal.UserRepository;
import com.nickels.core.users.internal.User;
import com.nickels.core.users.UserService;
import com.nickels.core.users.UserDto;

import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    UserServiceImpl(UserRepository repository) { // sem @Autowired
        this.repository = repository;
    }

    @Override
    @Transactional
    public UserDto create(String name, String password, String email) {
        if(repository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email ja cadastrado");
        }

        User user = repository.save(new User(name, email, password)); //TODO: Conseguir adicionar o password encoder
        return toDto(user);
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<UserDto> findById(UUID id) {
        return repository.findById(id).map(this::toDto);
    }

    private UserDto toDto(User u) {
        return new UserDto(u.getId(), u.getName(), u.getEmail());
    }
}
