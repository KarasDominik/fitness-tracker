package karas.dominik.fitnesstracker.useraccount.application;

import karas.dominik.fitnesstracker.useraccount.application.dto.CreateUserAccountCommand;
import karas.dominik.fitnesstracker.common.user.UserId;
import karas.dominik.fitnesstracker.useraccount.application.exception.UserAccountCreationException;
import karas.dominik.fitnesstracker.useraccount.infrastructure.persistence.UserAccount;
import karas.dominik.fitnesstracker.useraccount.infrastructure.persistence.UserAccounts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static karas.dominik.fitnesstracker.common.exception.GeneralAssertions.isFalse;

@Service
@RequiredArgsConstructor
@Slf4j
class CreateUserAccountUseCase {

    private final UserAccounts userAccounts;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserId execute(CreateUserAccountCommand command) {
        log.info("Creating user {}", command.email());
        assertUserCanBeCreated(command);
        var user = UserAccount.create(command, passwordEncoder::encode);
        userAccounts.save(user);
        log.info("User account {} created", command.email());
        return user.id();
    }

    private void assertUserCanBeCreated(CreateUserAccountCommand command) {
        isFalse(userAccounts.existsByEmail(command.email().value()),
                () -> new UserAccountCreationException("Email already taken"));
    }
}
