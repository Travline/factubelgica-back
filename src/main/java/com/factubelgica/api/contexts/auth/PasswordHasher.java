package com.factubelgica.api.contexts.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordHasher {
  private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

  public String hash(String plainPassword) {
    return encoder.encode(plainPassword);
  }

  public Boolean compare(String plainPassword, String hashedPassword) {
    return encoder.matches(plainPassword, hashedPassword);
  }
}
