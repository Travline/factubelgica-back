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
public class UsersErrorhandler {
  @ExceptionHandler(ErrorCreatingUser.class)
  public ResponseEntity<ErrorRespone> handleCreatingUser(ErrorCreatingUser ecu) {
    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(new ErrorRespone("USER_CANNOT_BE_CREATED", ecu.getMessage()));
  }

  @ExceptionHandler(UsersNotFound.class)
  public ResponseEntity<ErrorRespone> handleListingUsers(UsersNotFound unf) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(new ErrorRespone("NOT_USERS_FOUND", unf.getMessage()));
  }
}
