package com.factubelgica.api.contexts.auth;

import java.util.Optional;

public interface IUserRepository {
  public Optional<User> save(User user);
  public Optional<User> findByEmail(String email);
}
