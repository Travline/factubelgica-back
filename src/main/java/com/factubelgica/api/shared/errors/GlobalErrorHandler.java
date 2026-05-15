package com.factubelgica.api.shared.errors;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class GlobalErrorHandler {
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorRespone> handleValidationArgs(MethodArgumentNotValidException manve) {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(new ErrorRespone("INVALID_VALUES", manve.getMessage()));
  }

  @ExceptionHandler(UserUnauthorizedException.class)
  public ResponseEntity<ErrorRespone> handleTokenValidation(UserUnauthorizedException uue) {
    return ResponseEntity
        .status(HttpStatus.UNAUTHORIZED)
        .body(new ErrorRespone("USER_UNAUTHORIZED", uue.getMessage()));
  }
}
