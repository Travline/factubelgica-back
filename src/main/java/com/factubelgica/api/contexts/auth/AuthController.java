package com.factubelgica.api.contexts.auth;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
  private final UserRegister register;

  @PostMapping("register")
  public ResponseEntity<?> register(@RequestBody @Valid UserRegisterRequest req) {
    User user = register.execute(req);

    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(UserRegisterResponse.fromUser(user));
  }
}
