package com.factubelgica.api.contexts.auth;

import com.factubelgica.api.contexts.auth.errors.ErrorCreatingUser;
import com.factubelgica.api.contexts.auth.errors.UserAlreadyExists;
import com.factubelgica.api.shared.core.UUIDv7;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserRegister {
  private final IUserRepository repository;
  private final UUIDv7 v7;
  private final PasswordHasher hasher;

  public User execute(UserRegisterRequest req) {
    repository
        .findByEmail(req.email())
        .orElseThrow(() -> new UserAlreadyExists("Email " + req.email() + "is already used"));

    UUID userId = v7.generate();
    String hashedPassword = hasher.hash(req.password());
    User userToSave = req.toUser(userId, hashedPassword);

    return repository
        .save(userToSave)
        .orElseThrow(() -> new ErrorCreatingUser("User with email "+ req.email() +" cannot be created"));
  }
}
