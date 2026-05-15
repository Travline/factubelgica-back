package com.factubelgica.api.contexts.auth.errors;

public class ErrorCreatingUser extends RuntimeException {
  public ErrorCreatingUser(String message) {
    super(message);
  }
}
