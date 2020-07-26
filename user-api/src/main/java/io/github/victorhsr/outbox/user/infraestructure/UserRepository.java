package io.github.victorhsr.outbox.user.infraestructure;

import io.github.victorhsr.outbox.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author victorhsr <victor.hugo.origins@gmail.com>
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
