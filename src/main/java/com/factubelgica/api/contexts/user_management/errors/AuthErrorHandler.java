package com.factubelgica.api.contexts.user_management.errors;

import com.factubelgica.api.shared.errors.ErrorRespone;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AuthErrorHandler {
  @ExceptionHandler(UserAlreadyExists.class)
  public ResponseEntity<ErrorRespone> handleUserExists(UserAlreadyExists uae) {
    return ResponseEntity
        .status(HttpStatus.CONFLICT)
        .body(new ErrorRespone("USER_ALREADY_EXISTS", uae.getMessage()));
  }

  @ExceptionHandler(ErrorCreatingUser.class)
  public ResponseEntity<ErrorRespone> handleCreatingUser(ErrorCreatingUser ecu) {
    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(new ErrorRespone("USER_CANNOT_BE_CREATED", ecu.getMessage()));
  }
}
