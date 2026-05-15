package com.factubelgica.api.contexts.user_management.controllers;

import com.factubelgica.api.contexts.user_management.dtos.UserRegisterRequest;
import com.factubelgica.api.contexts.user_management.dtos.UserRegisterResponse;
import com.factubelgica.api.contexts.user_management.models.User;
import com.factubelgica.api.contexts.user_management.services.UserRegister;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
public class RegisterController {
  private final UserRegister register;

  @PostMapping("users")
  public ResponseEntity<?> register(@RequestBody @Valid UserRegisterRequest req) {
    User user = register.execute(req);

    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(UserRegisterResponse.fromUser(user));
  }
}
