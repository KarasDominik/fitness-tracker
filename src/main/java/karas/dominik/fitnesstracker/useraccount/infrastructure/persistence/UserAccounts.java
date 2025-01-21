package karas.dominik.fitnesstracker.useraccount.infrastructure.persistence;

import karas.dominik.fitnesstracker.common.user.UserId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccounts extends CrudRepository<UserAccount, UserId> {

    Optional<UserAccount> findByEmail(String email);

    boolean existsByEmail(String email);
}
