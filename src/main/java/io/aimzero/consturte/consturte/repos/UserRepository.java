package io.aimzero.consturte.consturte.repos;

import io.aimzero.consturte.consturte.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByRtAndIdNot(User user, final Long id);

}
