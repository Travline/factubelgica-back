package com.factubelgica.api.contexts.user_management.persistance;

import com.factubelgica.api.contexts.user_management.models.User;
import com.factubelgica.api.shared.utils.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserRepository implements IUserRepository {

  private final JpaUserRepository jpaUserRepository;

  @Override
  public Optional<User> save(User user) {
    try {
      UserSchema newUser = UserSchema.fromUser(user);
      UserSchema savedUser = jpaUserRepository.save(newUser);
      return Optional.of(savedUser.toUser());
    } catch (Exception e) {
      Slf4j.logger.warn("Error saving user", e);
      return Optional.empty();
    }
  }

  @Override
  public Optional<User> findByEmail(String email) {
    try {
      return jpaUserRepository
          .findByEmail(email)
          .map(UserSchema::toUser);
    }
    catch (Exception e) {
      Slf4j.logger.warn("Error saving user", e);
      return Optional.empty();
    }
  }
}
