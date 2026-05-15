package com.factubelgica.api.contexts.user_management.persistance;

import com.factubelgica.api.contexts.user_management.models.User;

import java.util.Optional;

public interface IUserRepository {
  public Optional<User> save(User user);
  public Optional<User> findByEmail(String email);
}
